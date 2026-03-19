package com.InicioUsuario.repaso.infrastructure.persistance;

import com.InicioUsuario.repaso.domain.model.Role;

import java.util.UUID;

public class UserRegisterEntity {

    private UUID id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;


    private UserRegisterEntity(UUID id, String username, String password, String email,
                               String firstName, String lastName, Role role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public UUID getId(){return this.id; }
    public String getUsername(){return this.username; }
    public String getLastName(){return this.lastName; }
    public String getPassword(){return this.password; }
    public String getEmail(){return this.email; }
    public String getFirstName(){return this.firstName; }
    public Role getRole(){return this.role; }

    /* No hay "SETTERS" a menos que sean estrictamente necesarios */


}
