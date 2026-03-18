package com.jdbc.JavaDB.application.port.in;

import com.jdbc.JavaDB.domain.model.User;

import java.util.Optional;

public interface GetUserUseCase {
    Optional<User> findById(Long id);
}
