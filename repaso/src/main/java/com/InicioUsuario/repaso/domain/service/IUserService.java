package com.InicioUsuario.repaso.domain.service;

import com.InicioUsuario.repaso.infrastructure.persistance.UserEntity;

import java.util.List;

public interface IUserService {

    public List<UserEntity> findAllUsers();
}
