package com.InicioUsuario.repaso.domain.model;

public enum Role {
    ADMIN ("admin"),
    CLIENT ("client"),
    ENTERPRISE ("enterprise");

    private String name;

    private Role(String name){
        this.name = name;
    }
}
