package com.trabajoTocho.TrabajoTocho.controller;

import com.trabajoTocho.TrabajoTocho.modelo.Response;
import com.trabajoTocho.TrabajoTocho.modelo.User;
import com.trabajoTocho.TrabajoTocho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:8000", "http://127.0.0.1:5500", "http://localhost:3000"})
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("findAll")
    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = service.listUsers();

        System.out.println("======Usuarios=======");
        for(User u : users){
            System.out.println(u.toString());
        }
        System.out.println("=====================");

        return users;
    }

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

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> update(@RequestBody User u, @PathVariable Long id ){
        User us = service.updateUser(u, id);
        return ResponseEntity.ok(us);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }



}
