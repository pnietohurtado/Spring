package com.jdbc.JavaDB.application.port.in;

import com.jdbc.JavaDB.domain.model.User;

import java.util.List;

public interface GetAllUserUseCase {
    List<User> findAll();
}
