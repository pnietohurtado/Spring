package com.trabajoTocho.TrabajoTocho.controller;

import com.trabajoTocho.TrabajoTocho.modelo.User;
import com.trabajoTocho.TrabajoTocho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    //Para poder crear un nuevo usuario
    @PostMapping//("/addUser")
    public ResponseEntity<User> create(@RequestBody User user){
        User u = service.createUser(user);
        System.out.println("User added Correctly! " + user.getUuid());
        return ResponseEntity.ok(u);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id ){
        User u = service.getUserById(id);
        System.out.println(id);
        return ResponseEntity.ok(u);
    }



}
