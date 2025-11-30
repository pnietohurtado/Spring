package com.cursoSecurity.Seguridad.service.models;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import com.cursoSecurity.Seguridad.service.models.dtos.LoginDTO;
import com.cursoSecurity.Seguridad.service.models.dtos.ResponseDTO;

import java.util.HashMap;

public interface IAuthService {

    public HashMap<String, String> login(LoginDTO login) throws Exception;
    public ResponseDTO register(UserEntity user) throws Exception;

}
