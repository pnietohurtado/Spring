package com.cursoSecurity.Seguridad.persistence.repositories;

import com.cursoSecurity.Seguridad.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true) // Consulta de forma nativa
    Optional<UserEntity> findByEmail(String email);



}
