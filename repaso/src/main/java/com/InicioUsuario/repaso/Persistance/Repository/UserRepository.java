package com.InicioUsuario.repaso.Persistance.Repository;

import com.InicioUsuario.repaso.Persistance.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findUserByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE username = :username", nativeQuery = true)
    Optional<UserEntity> findUserByUser(String username);

}
