package com.backend.BackEnd.service;

import com.backend.BackEnd.modelo.Alumno;
import com.backend.BackEnd.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repo;

    public ArrayList<Alumno> getAll(){
        return (ArrayList<Alumno>) repo.findAll();
    }

    public Alumno createAlumno(Alumno al){
        return repo.save(al);
    }



}
