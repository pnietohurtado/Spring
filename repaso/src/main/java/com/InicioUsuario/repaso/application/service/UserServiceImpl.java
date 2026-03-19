package com.InicioUsuario.repaso.application.service;

import com.InicioUsuario.repaso.domain.service.IUserService;
import com.InicioUsuario.repaso.infrastructure.persistance.UserEntity;
import com.InicioUsuario.repaso.infrastructure.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<UserEntity> findAllUsers() {
        return repo.findAll();
    }
}
