package com.InicioUsuario.repaso.Controller;

import com.InicioUsuario.repaso.Persistance.Entity.UserEntity;
import com.InicioUsuario.repaso.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/findAll")
    public List<UserEntity> findAllUsers(){
        return service.findAllUsers();
    }


}
