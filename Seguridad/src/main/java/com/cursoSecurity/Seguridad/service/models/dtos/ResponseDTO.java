package com.cursoSecurity.Seguridad.service.models.dtos;

public class ResponseDTO {

    private int numErrors; // Número de los errores
    private String message;

    public ResponseDTO(){}

    public int getNumErrors(){return this.numErrors;}
    public String getMessage(){return this.message; }

    public void setNumErrors(int numErros){this.numErrors = numErros; }
    public void setMessage(String message){this.message = message; }
}
