package com.cursoSecurity.Seguridad.controller;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import com.cursoSecurity.Seguridad.service.IUserService;
import com.cursoSecurity.Seguridad.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<UserEntity>> findAll(){
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }


}
