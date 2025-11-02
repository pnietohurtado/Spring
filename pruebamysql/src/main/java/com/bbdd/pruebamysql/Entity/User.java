package com.bbdd.pruebamysql.Entity;

import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;

@Entity
public class User {

    private int id;
    private String nombre;
    private String apellido;

    public User(){}
    public User( String n, String a){this(); this.nombre = n; this.apellido = a;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nID: ").append(this.id).append(" \nNombre => ").append(this.nombre)
                .append("\nApellido => ").append(this.apellido).append("\n==============");

        return sb.toString();
    }

}
