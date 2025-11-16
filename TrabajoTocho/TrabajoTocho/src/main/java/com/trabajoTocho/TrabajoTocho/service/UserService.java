package com.trabajoTocho.TrabajoTocho.service;

import com.trabajoTocho.TrabajoTocho.modelo.User;
import com.trabajoTocho.TrabajoTocho.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public ArrayList<User> listUsers(){
        return (ArrayList<User>) repo.findAll();
    }

    public User createUser(User user){
        return repo.save(user);
    }

    public User getUserById(Long id){
        return repo.getReferenceById(id);
    }

    public User updateUser(User u, Long id){
        User user = repo.getReferenceById(id);
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        user.setLastConnection(u.getLastConnection());
        user.setTimeLastConnection(u.getTimeLastConnection());

        return repo.save(user);
    }

    public void deleteUser(Long id){
        repo.deleteById(id);
    }

}
