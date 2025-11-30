package com.cursoSecurity.Seguridad.service;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;

import java.util.List;

public interface IUserService {
    public List<UserEntity> findAllUsers();

}
