package com.trabajoTocho.TrabajoTocho.controller;

import com.trabajoTocho.TrabajoTocho.modelo.Profile;
import com.trabajoTocho.TrabajoTocho.modelo.User;
import com.trabajoTocho.TrabajoTocho.repositorio.UserRepository;
import com.trabajoTocho.TrabajoTocho.service.ProfileService;
import com.trabajoTocho.TrabajoTocho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @Autowired
    private UserService serviceUser;

    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody Profile pro){
        User u = serviceUser.getUserById(pro.getUser().getUuid());
        System.err.println(u);

        Profile prof = new Profile();
        prof.setUser(u);
        prof.setDescription(pro.getDescription());
        prof.setNumberFollowers(pro.getNumberFollowers());

        service.addProfile(prof);
        return ResponseEntity.ok(prof);
    }

}
