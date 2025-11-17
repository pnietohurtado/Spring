package com.trabajoTocho.TrabajoTocho.controller;

import com.trabajoTocho.TrabajoTocho.modelo.Profile;
import com.trabajoTocho.TrabajoTocho.modelo.User;
import com.trabajoTocho.TrabajoTocho.repositorio.UserRepository;
import com.trabajoTocho.TrabajoTocho.service.ProfileService;
import com.trabajoTocho.TrabajoTocho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @Autowired
    private UserService serviceUser;

    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody Profile pro){

        Profile prof = service.addProfile(pro);
        return ResponseEntity.ok(prof);
    }

    @GetMapping("findAll")
    public ArrayList<Profile> findAllProfile(){
        ArrayList<Profile> pro = service.findAllProfile();
        return pro;
    }

}
