package com.udemy.udemy.service;

import com.udemy.udemy.LaptopRepository;
import com.udemy.udemy.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    // Básicamente te indica que estas llevando a cabo en esta clase un servicio y
    // no una clase normal como un Bean


    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap){
        repo.save(lap);
    }

    public boolean isGoodforPrice(Laptop lap){
        return true;
    }

}
