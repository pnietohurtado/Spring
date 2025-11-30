package com.cursoSecurity.Seguridad.service;

import com.nimbusds.jwt.JWTClaimsSet;

public interface IJWTUtilityService {

    public String generateJWT(Long uuid);
    public JWTClaimsSet parseJWT(String jwt);

}
