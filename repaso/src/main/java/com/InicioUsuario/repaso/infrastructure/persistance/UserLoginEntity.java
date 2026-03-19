package com.InicioUsuario.repaso.infrastructure.persistance;

import com.InicioUsuario.repaso.domain.model.Role;

import java.util.UUID;

public class UserLoginEntity {

    private UUID id;
    private String username;
    private String password;
    private Role role;

    private UserLoginEntity(UUID id, String username, String password, Role role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UUID getId(){return this.id;}
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public Role getRole(){return this.role;}

    /* No hay "SETTERS" a menos que sean estrictamente necesarios */

}
