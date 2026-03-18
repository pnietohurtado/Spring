package com.jdbc.JavaDB.application.port.in;

import com.jdbc.JavaDB.domain.model.User;

public interface CreateUserUseCase
/*Aquí vamos a tener las funcionalidades que vamos a utilizar en este caso
* como la creación de un usuario*/
{
    User createUser(User user);
}
