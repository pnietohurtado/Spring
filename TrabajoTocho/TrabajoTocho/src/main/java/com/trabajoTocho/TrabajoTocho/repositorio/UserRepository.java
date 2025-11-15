package com.trabajoTocho.TrabajoTocho.repositorio;

import com.trabajoTocho.TrabajoTocho.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
