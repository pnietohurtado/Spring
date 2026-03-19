package com.InicioUsuario.repaso.domain.service;

import com.InicioUsuario.repaso.application.dto.LoginDTO;
import com.InicioUsuario.repaso.application.dto.RegisterDTO;
import com.InicioUsuario.repaso.application.dto.ResponseDTO;

import java.util.HashMap;
import java.util.UUID;

public interface IAuthService {
    public HashMap<String, String> login(LoginDTO login, String id) throws Exception;
    public ResponseDTO register(RegisterDTO register) throws Exception;
}
