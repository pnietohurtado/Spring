package com.trabajoTocho.TrabajoTocho.service;

import com.trabajoTocho.TrabajoTocho.modelo.User;
import com.trabajoTocho.TrabajoTocho.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User createUser(User user){
        return repo.save(user);
    }

}
