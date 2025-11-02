package com.bbdd.pruebamysql.Controller;

import com.bbdd.pruebamysql.Entity.User;
import com.bbdd.pruebamysql.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private ServiceUser service;

    @PostMapping("/crear")
    public String crear(@RequestBody User u){
        service.create(u);

        return "Usuario creado";
    }
}
