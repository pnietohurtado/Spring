package com.jdbc.JavaDB.application.port.out;

import com.jdbc.JavaDB.domain.model.User;
import com.jdbc.JavaDB.infraestructure.persistance.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPortOutput {
    User save(User user);
    Optional<User> getById(Long id);
    Optional<List<UserEntity>> findAll();
}
