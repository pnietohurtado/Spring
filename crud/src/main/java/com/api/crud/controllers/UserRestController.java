package com.api.crud.controllers;

import com.api.crud.models.UsersModel;
import com.api.crud.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/bbdd")
public class UserRestController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getUsers")
    public ArrayList<UsersModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/saveUser")
    public UsersModel saveUser(@RequestBody UsersModel user){
        return userService.saveUser(user);
    }

    @GetMapping("/findUser/{name}")
    public Optional<UsersModel> findUser(@PathVariable Long id){
        return userService.getById(id);
    }

}
