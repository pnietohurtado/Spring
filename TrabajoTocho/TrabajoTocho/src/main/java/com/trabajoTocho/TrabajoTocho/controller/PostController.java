package com.trabajoTocho.TrabajoTocho.controller;

import com.trabajoTocho.TrabajoTocho.modelo.Post;
import com.trabajoTocho.TrabajoTocho.modelo.Profile;
import com.trabajoTocho.TrabajoTocho.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping("findAll")
    public ArrayList<Post> findAllPost(){
        ArrayList<Post> pro = service.findAllPost();
        return pro;
    }
}
