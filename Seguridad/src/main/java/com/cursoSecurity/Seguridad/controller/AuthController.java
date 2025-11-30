package com.cursoSecurity.Seguridad.controller;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import com.cursoSecurity.Seguridad.service.IJWTUtilityService;
import com.cursoSecurity.Seguridad.service.models.IAuthService;
import com.cursoSecurity.Seguridad.service.models.dtos.LoginDTO;
import com.cursoSecurity.Seguridad.service.models.dtos.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService service;

    @PostMapping("/register")
    private ResponseEntity<ResponseDTO> registerUser(@RequestBody UserEntity user){
        try {
            return new ResponseEntity<>(service.register(user), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    private ResponseEntity<HashMap<String, String>> loginUser(@RequestBody LoginDTO login){
        try {
            HashMap<String, String> log = service.login(login);
            if(log.containsKey("jwt")){
                return new ResponseEntity<>(log, HttpStatus.OK);
            }
            return new ResponseEntity<>(log, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
