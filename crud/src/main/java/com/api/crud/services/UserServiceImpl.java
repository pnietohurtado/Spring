package com.api.crud.services;

import com.api.crud.models.UsersModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    private IUserRepository repo;

    public ArrayList<UsersModel> getUsers(){
        return(ArrayList<UsersModel>) repo.findAll();
    }

    public UsersModel saveUser(UsersModel user){
        return repo.save(user);
    }

    public Optional<UsersModel> getById(Long id){
        return repo.findById(id);
    }

    public Optional<UsersModel> updateUser(UsersModel model, Long id){
        Optional<UsersModel> user =repo.findById(id);
        return user;  
    }
}
