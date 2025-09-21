package com.openwebinars.demo.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio3 {

    @Autowired
    public Utils utils;
}
