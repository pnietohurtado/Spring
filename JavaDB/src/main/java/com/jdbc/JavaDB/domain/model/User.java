package com.jdbc.JavaDB.domain.model;

public record User(
        Long id,
        String fistName,
        String lastName
)

/*
* Dentro del "Domain" todo el código en este debe de ser puro Java
* es decir, no podemos incluir ningún tipo de framework o librería
* */
{
}
