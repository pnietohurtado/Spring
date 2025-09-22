package com.data.data;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainDeMentira {

    @Autowired
    private Repository repo;

    @PostConstruct
    public void run(){
        Productos p = new Productos("Un Producto", 234.5, null);
        repo.save(p);

        repo.findAll().forEach(System.out::println);

        System.out.println("0==================0");
        repo.findByNombre("Monitor").forEach(System.out::println);
    }
}
