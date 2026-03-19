package com.jdbc.JavaDB.infraestructure.persistance;

import com.jdbc.JavaDB.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {

}
