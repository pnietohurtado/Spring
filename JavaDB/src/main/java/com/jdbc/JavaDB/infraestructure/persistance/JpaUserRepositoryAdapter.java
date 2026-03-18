package com.jdbc.JavaDB.infraestructure.persistance;

import com.jdbc.JavaDB.application.port.out.UserRepositoryPortOutput;
import com.jdbc.JavaDB.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPortOutput {

    private final SpringDataUserRepository springDataUserRepository;

    public JpaUserRepositoryAdapter(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(user.id(), user.fistName(), user.lastName());
        final UserEntity savedUser = springDataUserRepository.save(userEntity);
        return new User(savedUser.id(), savedUser.getFirstnName(), savedUser.getLastName());
    }
}
