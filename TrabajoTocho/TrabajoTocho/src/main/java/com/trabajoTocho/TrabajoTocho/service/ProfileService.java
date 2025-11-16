package com.trabajoTocho.TrabajoTocho.service;

import com.trabajoTocho.TrabajoTocho.modelo.Profile;
import com.trabajoTocho.TrabajoTocho.repositorio.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repo;

    public Profile addProfile(Profile profile){
        return repo.save(profile);
    }


}
