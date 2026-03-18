package com.jdbc.JavaDB.infraestructure.controller.dto;

public record UserResponse(
        Long id,
        String firstName,
        String lastName
) {
}
