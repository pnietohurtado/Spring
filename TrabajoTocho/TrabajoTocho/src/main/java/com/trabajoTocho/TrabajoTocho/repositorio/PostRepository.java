package com.trabajoTocho.TrabajoTocho.repositorio;

import com.trabajoTocho.TrabajoTocho.modelo.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
