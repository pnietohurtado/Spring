package com.InicioUsuario.repaso.domain.model;

import java.util.UUID;

public record User(
        UUID id,
        String username,
        String password,
        Role role
) {
}
