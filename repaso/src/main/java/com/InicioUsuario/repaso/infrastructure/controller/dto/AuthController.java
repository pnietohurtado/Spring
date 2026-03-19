package com.InicioUsuario.repaso.infrastructure.controller.dto;

import com.InicioUsuario.repaso.application.dto.LoginDTO;
import com.InicioUsuario.repaso.application.dto.RegisterDTO;
import com.InicioUsuario.repaso.application.dto.ResponseDTO;
import com.InicioUsuario.repaso.application.service.AuthServiceImpl;
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
    private AuthServiceImpl service;

    @PostMapping("/login")
    private ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO login){
        ResponseEntity<ResponseDTO> res = null;
        try{
            HashMap<String, String> log = null;
            /*
            if(login.getUsername() != null){
                log = service.login(login, "email");
            }
            */

            if(login.getUsername() != null){
                log = service.login(login, "username");
            }

            if(log.containsKey("jwt")){
                res =  new ResponseEntity(log, HttpStatus.OK);
            }else{
                res =  new ResponseEntity(log, HttpStatus.UNAUTHORIZED);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return res;
    }

    @PostMapping("/register")
    private ResponseDTO register(@RequestBody RegisterDTO register){
        ResponseDTO res = null;

        try{

            res = service.register(register); 

        }catch (Exception e){
            e.printStackTrace();
        }

        return res;
    }
}
