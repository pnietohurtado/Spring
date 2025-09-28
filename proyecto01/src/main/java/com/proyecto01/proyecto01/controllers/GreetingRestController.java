package com.proyecto01.proyecto01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @GetMapping({"/saludo/{name}", "/hola/{name}"}) // Un ejemplo útil es usar para un inicio de sesión "http://github.com/pnh0002"
    public String greeting(@PathVariable String name){
        return "Hola " + name;
    }

}
