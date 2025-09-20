package com.openwebinars.demo.autowired;

import org.springframework.stereotype.Repository;

@Repository
public class MiRepositorio {
    public void realizarOperacion(){
        System.out.println("Ejecutando operacion");
    }
}
