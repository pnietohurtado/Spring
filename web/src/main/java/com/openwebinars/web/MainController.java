package com.openwebinars.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // De esta forma vamos a poder a acceder a nuestro programa desde el servidor "http://localhost:8080/"
    @GetMapping("/") // Endpoint que nos permite acceder a algún servicio
    public String welcome(Model model){
        model.addAttribute("message", "Welcome to OpenWebinars!");
        return "index" ;
    }

    @GetMapping("/me")
    public String me(Model model){
        model.addAttribute("nombre", "Pablo Nieto Hurtado , 22 años");
        model.addAttribute("tlf", "Tlf : 635 29 09 93");
        return "me";
    }

}
