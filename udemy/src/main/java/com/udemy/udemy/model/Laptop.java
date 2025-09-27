package com.udemy.udemy.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    public void compile(){
        System.out.println("Start compiling in the Laptop!");
    }

}
