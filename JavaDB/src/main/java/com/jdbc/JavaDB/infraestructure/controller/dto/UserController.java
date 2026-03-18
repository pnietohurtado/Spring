package com.jdbc.JavaDB.infraestructure.controller.dto;

import com.jdbc.JavaDB.application.port.in.CreateUserUseCase;
import com.jdbc.JavaDB.domain.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }


    @PostMapping
    public User createUser(@RequestBody UserRequest userRequest ){
        final User user = new User(null, userRequest.firstName(), userRequest.lastName());
        return createUserUseCase.createUser(user);
    }
}
