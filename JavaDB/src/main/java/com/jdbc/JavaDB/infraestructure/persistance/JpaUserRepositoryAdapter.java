package com.jdbc.JavaDB.infraestructure.persistance;

import com.jdbc.JavaDB.application.port.out.UserRepositoryPortOutput;
import com.jdbc.JavaDB.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        return new User(savedUser.id(), savedUser.getFirstName(), savedUser.getLastName());
    }

    @Override
    public Optional<User> getById(Long id) {
        final Optional<UserEntity> savedUser = springDataUserRepository.findById(id);
        return Optional.of(new User(savedUser.get().id(), savedUser.get().getFirstName(), savedUser.get().getLastName()));

    }

    @Override
    public Optional<List<UserEntity>> findAll() {
        final List<UserEntity> allUsersFound = springDataUserRepository.findAll();
        return Optional.of(allUsersFound);
    }
}
