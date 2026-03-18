package com.jdbc.JavaDB.application.port.out;

import com.jdbc.JavaDB.domain.model.User;

public interface UserRepositoryPortOutput {
    User save(User user);
}
