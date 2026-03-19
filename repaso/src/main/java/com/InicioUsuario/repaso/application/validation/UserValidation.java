package com.InicioUsuario.repaso.application.validation;

import com.InicioUsuario.repaso.application.dto.ResponseDTO;
import com.InicioUsuario.repaso.infrastructure.persistance.UserEntity;

import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    public ResponseDTO validation(UserEntity user){
        ResponseDTO response  = new ResponseDTO();

        response.setError(0);
        if(user.getUsername() == null ||
        user.getUsername().length() < 3 ||
        user.getUsername().length() > 20) {
            response.setError(response.getNumErrors() + 1);
            response.setMessage("The username validation did not match the parameters!");
        }

        if(user.getEmail() == null ||
        !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            response.setError(response.getNumErrors() + 1 );
            response.setMessage("The email validation did not match the parameters!");
        }

        if(user.getPassword() == null ||
        user.getPassword().length() < 3 ||
        user.getPassword().length() > 20 ||
        !user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")){
            response.setError(response.getNumErrors() + 1);
            response.setMessage("The password validation did not match the parameters!");
        }

        return response;

    }

}
