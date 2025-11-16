package com.trabajoTocho.TrabajoTocho.controller;

import com.trabajoTocho.TrabajoTocho.modelo.Post;
import com.trabajoTocho.TrabajoTocho.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post p){
        Post po = service.addPost(p);
        return ResponseEntity.ok(po);
    }
}
