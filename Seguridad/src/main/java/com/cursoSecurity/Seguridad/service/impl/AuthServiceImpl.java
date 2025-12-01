package com.cursoSecurity.Seguridad.service.impl;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import com.cursoSecurity.Seguridad.persistence.repositories.UserRepository;
import com.cursoSecurity.Seguridad.service.IJWTUtilityService;
import com.cursoSecurity.Seguridad.service.models.IAuthService;
import com.cursoSecurity.Seguridad.service.models.dtos.LoginDTO;
import com.cursoSecurity.Seguridad.service.models.dtos.ResponseDTO;
import com.cursoSecurity.Seguridad.service.models.validation.UserValidation;
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
    public HashMap<String, String> login(LoginDTO login) throws Exception {
        try{

            HashMap<String, String> jwt = new HashMap<>();
            Optional<UserEntity> user = repo.findByEmail(login.getEmail());

            if(user.isEmpty()){
                jwt.put("error", "User not registered!");
                return jwt;
            }

            // Verificación de la contraseña
            if(verifyPassword(login.getPassword(), user.get().getPassword())){
                jwt.put("jwt", service.generateJWT(user.get().getUuid()));
            }else{
                jwt.put("error" , "Not matching passwords");
                return jwt;
            }

            return jwt;


        }catch(Exception e){
            throw new Exception(e.toString());
        }
    }

    @Override
    public ResponseDTO register(UserEntity user) throws Exception{
        try{

            ResponseDTO response = validation.validate(user);

            if(response.getNumErrors() > 0 ){
                return response;
            }

            List<UserEntity> getAllUsers = repo.findAll();
            for(UserEntity u : getAllUsers){
                /*if(u != null){
                    response.setNumErrors(1);
                    response.setMessage("User already Exists!");
                    return response;
                }*/
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setPassword(encoder.encode(user.getPassword()));

            System.out.println("Se debe de guardar el usuario de email " + user.getEmail());
            repo.save(user);

            response.setMessage("OK!");
            return response;
        }catch(Exception e){
            throw new Exception(e.toString());
        }
    }


    private boolean verifyPassword(String enteredPassword, String storedPassword){
        BCryptPasswordEncoder encoded = new BCryptPasswordEncoder();
        return encoded.matches(enteredPassword, storedPassword);
    }
}
