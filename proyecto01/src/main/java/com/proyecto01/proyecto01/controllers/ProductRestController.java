package com.proyecto01.proyecto01.controllers;

import com.proyecto01.proyecto01.models.Product;
import com.proyecto01.proyecto01.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    @Qualifier("JAVA") // Elije la interfaz que vamos a utilizar 
    private ProductService repo;


    @GetMapping
    private ResponseEntity<?> getProducts() {
        List<Product> products = repo.getProducts();
        return ResponseEntity.ok(products);
    }

}
