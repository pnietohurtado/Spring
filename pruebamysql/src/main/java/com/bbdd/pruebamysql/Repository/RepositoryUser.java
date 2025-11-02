package com.bbdd.pruebamysql.Repository;

import com.bbdd.pruebamysql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {
}
