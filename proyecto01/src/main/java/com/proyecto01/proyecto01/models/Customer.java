package com.proyecto01.proyecto01.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Customer
/*
* Una clase la cual es nativa de java es una clase POJO,ya que
* cuenta con los getter y setters
*
* Por lo que no hay que poner @Component ni @Scope("prototype")
* */
{

    private int id;
    private String name;
    private String user_name;
    private String pass;

    public Customer(int i, String n, String u, String p){
        this.id = i;
        this.name = n;
        this.user_name = u;
        this.pass = p;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\n' +
                ", user_name='" + user_name + '\n' +
            ", pass='" + pass + '\n' +
                '}';
    }
}
