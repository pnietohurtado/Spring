package com.cursoSecurity.Seguridad.service.models.dtos;

public class LoginDTO {

    // Estos van a ser los datos necesarios que vamos a necesitar para "logearnos"
    private String email;
    private String password;

    public LoginDTO(){}

    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}

    public void setEmail(String email){this.email = email; }
    public void setPassword(String password){this.password = password; }

}
