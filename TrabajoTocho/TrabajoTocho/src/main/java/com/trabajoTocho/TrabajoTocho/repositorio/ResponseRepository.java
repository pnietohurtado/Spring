package com.trabajoTocho.TrabajoTocho.repositorio;

import com.trabajoTocho.TrabajoTocho.modelo.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
}
