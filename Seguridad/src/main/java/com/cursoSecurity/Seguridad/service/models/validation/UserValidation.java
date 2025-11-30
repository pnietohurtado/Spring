package com.cursoSecurity.Seguridad.service.models.validation;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import com.cursoSecurity.Seguridad.service.models.dtos.ResponseDTO;

public class UserValidation {
    // Se va a encargar de asegurarnos de que el login sea correcto osea que cumpla ciertos
    // parámetros

    public ResponseDTO validate(UserEntity user){
        ResponseDTO  response = new ResponseDTO();

        response.setNumErrors(0);

        if(user.getFirstName() == null ||
                user.getFirstName().length() < 3 ||
                user.getFirstName().length() > 15){
            response.setNumErrors(response.getNumErrors() + 1);
            response.setMessage("The field 'firstName' can not be null, and neither it could be larger than 15 nor shorter than 3 characters!");
        }

        if(user.getLastName() == null ||
                user.getLastName().length() < 3 ||
                user.getLastName().length() > 30){
            response.setNumErrors(response.getNumErrors() + 1);
            response.setMessage("The field 'lastName' can not be null, and neither it could be larger than 30 nor shorter than 3 characters!");
        }

        if(user.getEmail() == null ||
                !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            response.setNumErrors(response.getNumErrors() + 1);
            response.setMessage("The field 'email' can not be null, and have to end with @gmail.com");
        }

        if(user.getPassword() == null ||
                !user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")){
            response.setNumErrors(response.getNumErrors() + 1);
            response.setMessage("The field 'password' can not be null, and must have a certain length");
        }

        return response;
    }


}
