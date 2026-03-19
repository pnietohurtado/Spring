package com.InicioUsuario.repaso.application.dto;

public class ResponseDTO {
    private int numErrors;
    private String message;

    public void setError(int error){this.numErrors = error; }
    public void setMessage(String message){this.message = message; }

    public int getNumErrors(){return this.numErrors;}
    public String getMessage(){return this.message; }
}
