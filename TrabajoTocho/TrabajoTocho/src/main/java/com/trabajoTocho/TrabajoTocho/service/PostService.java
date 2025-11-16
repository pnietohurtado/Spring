package com.trabajoTocho.TrabajoTocho.service;

import com.trabajoTocho.TrabajoTocho.modelo.Post;
import com.trabajoTocho.TrabajoTocho.repositorio.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post addPost(Post p){
        return repo.save(p);
    }

}
