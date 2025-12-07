package com.InicioUsuario.repaso.Service.Impl;

import com.InicioUsuario.repaso.Persistance.Entity.UserEntity;
import com.InicioUsuario.repaso.Persistance.Repository.UserRepository;
import com.InicioUsuario.repaso.Service.DTO.LoginDTO;
import com.InicioUsuario.repaso.Service.DTO.ResponseDTO;
import com.InicioUsuario.repaso.Service.Interface.IAuthService;
import com.InicioUsuario.repaso.Service.Interface.IJWTUtilityService;
import com.InicioUsuario.repaso.Service.Validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private IJWTUtilityService service;

    @Autowired
    private UserValidation validation;

    @Override
    public HashMap<String, String> login(LoginDTO login, String identifier) throws Exception {

        // Instancioamos el Hashmap que más tarde vamos a retornar
        HashMap<String, String> jwt = new HashMap<>();
        Optional<UserEntity> user = null;

        if(identifier.equals("username")) {
            user = repo.findUserByUser(login.getUsername()); // Puede no devolvernos nada
        } if(identifier.equals("email")){
            user = repo.findUserByEmail(login.getEmail());
        }

        if(user.isEmpty() && identifier.equals("username")){
            jwt.put("error", "There's no user with that specific username on the database!");
            return jwt;
        } if(user.isEmpty() && identifier.equals("email")){
            jwt.put("error", "There's no user with that specific email registered in our database!");
            return jwt;
        }

        // Verificación de la contraseña
        if(verifyPassword(login.getPassword(), user.get().getPassword())){
            jwt.put("jwt", service.generateJWT(user.get().getUuid()));
        }else{
            jwt.put("error", "Not matching passwords!");
            return jwt;
        }

        return jwt;


    }

    @Override
    public ResponseDTO register(UserEntity user) throws Exception {
        ResponseDTO response = validation.validation(user);

        if(response.getError() > 0){
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
        user.setPassword(encoder.encode(user.getPassword()));

        repo.save(user);

        if(response.getError() > 0){
            System.out.println("Errores de validacion! : " + response.getMessage());
            return response;
        }

        response.setMessage("Everything OK");
        return response;
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword){
        BCryptPasswordEncoder encoded = new BCryptPasswordEncoder();
        return encoded.matches(enteredPassword, storedPassword);
    }
}
