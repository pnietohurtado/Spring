package com.bbdd.pruebamysql.Service;

import com.bbdd.pruebamysql.Entity.User;
import com.bbdd.pruebamysql.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser repo;

    public void create(User u){
        User usuario = new User();
        usuario.setNombre(u.getNombre());
        usuario.setApellido(u.getApellido());
        repo.save(usuario);
    }

}
