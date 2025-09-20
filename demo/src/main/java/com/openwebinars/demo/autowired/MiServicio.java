package com.openwebinars.demo.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiServicio {

    @Autowired
    private MiRepositorio miRepositorio;

    public void ejecutar() {
        miRepositorio.realizarOperacion();
    }
}
