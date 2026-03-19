package com.InicioUsuario.repaso.application.dto;

public class LoginDTO
    /* Clase modelo para el login de los usuarios
    * voy a tener que hacer lo mismo con el register
    * RegisterDTO (Pojo) */
{
    private String username;
    private String password;

    public LoginDTO(){}

    public String getUsername(){return this.username;}
    public String getPassword (){return this.password; }

    /* De nuevo no voy a hacer los "Setter" ya que por ahora no son necesarios */

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append(this.username).append("\n")
                .append("Password: ").append(this.password);
        return sb.toString();
    }

}
