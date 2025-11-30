package com.cursoSecurity.Seguridad.service.impl;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import com.cursoSecurity.Seguridad.persistence.repositories.UserRepository;
import com.cursoSecurity.Seguridad.service.IJWTUtilityService;
import com.cursoSecurity.Seguridad.service.models.IAuthService;
import com.cursoSecurity.Seguridad.service.models.dtos.LoginDTO;
import com.cursoSecurity.Seguridad.service.models.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Optional;

public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private IJWTUtilityService service;

    @Autowired
    private UserValidation validation;

    public HashMap<String, String> login(LoginDTO login) throws Exception {
        try{

            HashMap<String, String> jwt = new HashMap<>();
            Optional<UserEntity> user = repo.findByEmail(login.getEmail());  

        }catch(Exception e){
            throw new Exception(e.toString());
        }
    }
}
