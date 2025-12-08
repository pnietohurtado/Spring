package com.InicioUsuario.repaso.Controller;

import com.InicioUsuario.repaso.Persistance.Entity.UserEntity;
import com.InicioUsuario.repaso.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/findAll")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<UserEntity> findAllUsers(){

        /*
        if(hasRole("ROLE_ADMIN")){
            System.out.println("Hi, you has access");
            return service.findAllUsers();
        }else{
            System.out.println("You dont!");
        }
        */

        return service.findAllUsers();
    }


    private boolean hasRole(String role){
        SecurityContext context = SecurityContextHolder.getContext();

        if(context == null){
            return false;
        }

        Authentication auth = context.getAuthentication();

        if(auth == null){
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for(GrantedAuthority authority : authorities){
            if(role.equals(authority.getAuthority())){
                return true;
            }
        }
        return false;
    }

}
