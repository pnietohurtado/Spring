package com.trabajoTocho.TrabajoTocho.controller;

import com.trabajoTocho.TrabajoTocho.modelo.Response;
import com.trabajoTocho.TrabajoTocho.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService service;


    @GetMapping("findAll")
    public ArrayList<Response> findAll(){
        ArrayList<Response> res = service.getAllResponse();
        return res;
    }


}
