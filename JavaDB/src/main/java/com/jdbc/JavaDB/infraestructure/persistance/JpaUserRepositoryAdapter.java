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
        User userEntity = new User(user.id(), user.fistName(), user.lastName());
        final User savedUser = springDataUserRepository.save(userEntity);
        return new User(savedUser.id(), savedUser.fistName(), savedUser.lastName());
    }

    @Override
    public Optional<User> getById(Long id) {
        final Optional<User> savedUser = springDataUserRepository.findById(id);
        return Optional.of(new User(savedUser.get().id(), savedUser.get().fistName(), savedUser.get().lastName()));

    }

    @Override
    public List<User> findAll() {
        final List<User> allUsersFound = springDataUserRepository.findAll();
        return allUsersFound;
    }
}
