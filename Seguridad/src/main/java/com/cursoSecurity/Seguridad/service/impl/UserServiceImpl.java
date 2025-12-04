package com.cursoSecurity.Seguridad.service.impl;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import com.cursoSecurity.Seguridad.persistence.repositories.UserRepository;
import com.cursoSecurity.Seguridad.service.IUserService;
import com.cursoSecurity.Seguridad.service.models.dtos.ResponseDTO;
import com.cursoSecurity.Seguridad.service.models.validation.UserValidation;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserValidation validation;

    @Override
    public List<UserEntity> findAllUsers() {
        //ResponseDTO response = new ResponseDTO();
        // Aquí quiero intentar poder mandar el error en caso de que el usuario no tenga permisos


        return userRepository.findAll();
    }
}
