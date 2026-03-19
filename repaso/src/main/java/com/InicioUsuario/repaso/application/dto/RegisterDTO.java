package com.InicioUsuario.repaso.application.dto;

public class RegisterDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public RegisterDTO(){}

    public String getFirstName(){return this.firstName;}
    public String getLastName(){return this.lastName; }
    public String getEmail(){return this.email; }
    public String getUsername(){return this.username; }
    public String getPassword() {return this.password;}

    public void setPassword(String password){this.password = password; }

    @Override // Cuestionable la implementación de un "toString" en este modelo
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(this.firstName).append("\n")
                .append("Last Name: ").append(this.lastName).append("\n")
                .append("Email: ").append(this.email).append("\n")
                .append("Username: ").append(this.username).append("\n")
                .append("Password: ").append(this.password).append("\n");

        return sb.toString();
    }
}
