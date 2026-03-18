package com.jdbc.JavaDB.infraestructure.controller.dto;

import com.jdbc.JavaDB.application.port.in.CreateUserUseCase;
import com.jdbc.JavaDB.application.port.in.GetAllUserUseCase;
import com.jdbc.JavaDB.application.port.in.GetUserUseCase;
import com.jdbc.JavaDB.domain.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final GetAllUserUseCase getAllUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase, GetAllUserUseCase getAllUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.getAllUserUseCase = getAllUserUseCase;
    }


    @PostMapping
    public User createUser(@RequestBody UserRequest userRequest ){
        final User user = new User(null, userRequest.firstName(), userRequest.lastName());
        return createUserUseCase.createUser(user);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id){
        final Optional<User> user = getUserUseCase.findById(id);
        return new UserResponse(user.get().id(), user.get().fistName(), user.get().lastName()); 
    }

    @GetMapping
    public List<User> getAllUsers(){
        return getAllUserUseCase.findAll();
    }
}
