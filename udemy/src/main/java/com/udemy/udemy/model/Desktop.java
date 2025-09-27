package com.udemy.udemy.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{
    public void compile(){
        System.out.println("Start compiling in the Desktop!");
    }

}