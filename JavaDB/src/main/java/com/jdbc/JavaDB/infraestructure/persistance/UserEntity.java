package com.jdbc.JavaDB.infraestructure.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private final Long id;
    private final String firstName;
    private final String lastName;


    public UserEntity(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long id(){
        return id;
    }

    public String getFirstnName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

}
