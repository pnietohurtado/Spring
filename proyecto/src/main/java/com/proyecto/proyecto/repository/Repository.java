package com.proyecto.proyecto.repository;

import com.proyecto.proyecto.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Product, Long> {

}
