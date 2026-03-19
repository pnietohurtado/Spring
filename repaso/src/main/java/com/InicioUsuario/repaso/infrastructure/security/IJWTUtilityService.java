package com.InicioUsuario.repaso.infrastructure.security;

import com.nimbusds.jwt.JWTClaimsSet;

import java.util.List;
import java.util.UUID;

public interface IJWTUtilityService {
    String generateJWT(UUID id , String username, List<String> roles);
    public JWTClaimsSet parseJWT(String jwt);
}
