package com.InicioUsuario.repaso.application.service;

import com.InicioUsuario.repaso.application.dto.LoginDTO;
import com.InicioUsuario.repaso.application.dto.RegisterDTO;
import com.InicioUsuario.repaso.application.dto.ResponseDTO;
import com.InicioUsuario.repaso.application.validation.UserValidation;
import com.InicioUsuario.repaso.domain.service.IAuthService;
import com.InicioUsuario.repaso.infrastructure.persistance.UserEntity;
import com.InicioUsuario.repaso.infrastructure.persistance.UserRegisterEntity;
import com.InicioUsuario.repaso.infrastructure.persistance.UserRepository;
import com.InicioUsuario.repaso.infrastructure.security.IJWTUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private IJWTUtilityService service;

    @Autowired
    private UserValidation validation;


    @Override
    public HashMap<String, String> login(LoginDTO login, String id) throws Exception {
        HashMap<String, String> jwt = new HashMap<>();
        Optional<UserEntity> user = null;

        if(id.equals("username")){
            user = repo.findUserByUser(login.getUsername());
        }

        if(user.isEmpty()){
            jwt.put("error", "There's no such user in the database!");
            return jwt;
        }

        if(verifyPassword(login.getPassword(), user.get().getPassword())){
            UserEntity userEntity = user.get();
            List<String> roles = userEntity.getAuthorities().stream()
                    .map(authority -> authority.getAuthority())
                    .collect(Collectors.toList());
            jwt.put("jwt", service.generateJWT(userEntity.getId(), userEntity.getUsername(), roles));
        }else{
            jwt.put("error" , "Not matching passwords");
            return jwt;
        }

        return jwt ;
    }

    @Override
    public ResponseDTO register(RegisterDTO register) throws Exception {

        UserEntity user = new UserEntity(register.getUsername(), register.getEmail(), register.getPassword(), register.getFirstName(),
                register.getLastName());
        ResponseDTO response = validation.validation(user);

        if(response.getNumErrors() > 0){
            return response;
        }

        List<UserEntity> getAllusers = repo.findAll();
        for(UserEntity u : getAllusers){
            if(u.getEmail().equals(user.getEmail())){
                response.setError(1);
                response.setMessage("There is already a user with that email/username!");
                return response;
            }
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        user.setPassword(encoder.encode(register.getPassword()));

        repo.save(user);

        return response;
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword){
        BCryptPasswordEncoder encoded = new BCryptPasswordEncoder();
        return encoded.matches(enteredPassword, storedPassword);
    }
}
