package com.cursoSecurity.Seguridad.service.impl;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import com.cursoSecurity.Seguridad.persistence.repositories.UserRepository;
import com.cursoSecurity.Seguridad.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }
}
