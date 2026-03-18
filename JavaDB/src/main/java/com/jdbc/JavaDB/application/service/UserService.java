package com.jdbc.JavaDB.application.service;

import com.jdbc.JavaDB.application.port.in.CreateUserUseCase;
import com.jdbc.JavaDB.application.port.out.UserRepositoryPortOutput;
import com.jdbc.JavaDB.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements CreateUserUseCase
    /*Implementación de la interfaz donde vamos a ejecutar las funciones de entrada como
    * lo puede ser la creación de un nuevo usuario. En este caso nosotros solo llamamos a la
    * función, pero necesitamos que el "puerto de salida" (out) se encargue de enviar estos
    * datos a una base de datos o a donde sea que lo queramos enviar.*/
{

    private final UserRepositoryPortOutput out;

    public UserService(UserRepositoryPortOutput out) {
        this.out = out;
    }


    @Override
    public User createUser(User user) {
        return out.save(user);
    }
}
