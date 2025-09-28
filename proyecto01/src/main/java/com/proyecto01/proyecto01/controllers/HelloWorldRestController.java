package com.proyecto01.proyecto01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController
/*
* Se va a encargar de ser una clase la cual contenga los métodos que vamos a
* usar para poder conectar con nuestra API Rest
* */
{

    @GetMapping({"/helloWorld", "/hw", "/hello"})
    public String helloWorld(){
        System.out.println("Solicitud Ejecutada!");
        return "Hello World";
    }

    @GetMapping("/helloWorld/owner")
    public String owner(){
        return "Pablo Nieto Hurtado \n Tlf: 635 29 09 93";
    }

}
