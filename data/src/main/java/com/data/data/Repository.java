package com.data.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Productos, Long> {
    List<Productos> findByPrecio(double precio);
    List<Productos> findByNombre(String nombre);
}
