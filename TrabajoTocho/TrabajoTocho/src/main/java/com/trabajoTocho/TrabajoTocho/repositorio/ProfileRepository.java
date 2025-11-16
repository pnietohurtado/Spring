package com.trabajoTocho.TrabajoTocho.repositorio;

import com.trabajoTocho.TrabajoTocho.modelo.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
