package com.proyecto01.proyecto01.controllers;

import com.proyecto01.proyecto01.configurations.ExternalizedConfigurations;
import com.proyecto01.proyecto01.models.Product;
import com.proyecto01.proyecto01.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    @Lazy
    //@Qualifier("JAVA") // Elije la interfaz que vamos a utilizar
    private ProductService repo;

    @Autowired
    @Lazy
    private ExternalizedConfigurations config;


    @GetMapping
    private ResponseEntity<?> getProducts() {
        System.out.println(config.toString());

        List<Product> products = repo.getProducts();
        return ResponseEntity.ok(products);
    }



}
