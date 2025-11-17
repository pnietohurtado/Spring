package com.trabajoTocho.TrabajoTocho.service;

import com.trabajoTocho.TrabajoTocho.modelo.Response;
import com.trabajoTocho.TrabajoTocho.repositorio.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository repo;

    public ArrayList<Response> getAllResponse(){
        return (ArrayList<Response>) repo.findAll();
    }

}
