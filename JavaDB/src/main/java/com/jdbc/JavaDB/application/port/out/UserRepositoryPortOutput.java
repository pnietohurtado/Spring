package com.jdbc.JavaDB.application.port.out;

import com.jdbc.JavaDB.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPortOutput {
    User save(User user);
    Optional<User> getById(Long id);
}
