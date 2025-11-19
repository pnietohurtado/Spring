package com.backend.BackEnd.controller;

import com.backend.BackEnd.modelo.Alumno;
import com.backend.BackEnd.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping("findAll")
    public ArrayList<Alumno> getAll(){
        ArrayList<Alumno> alumnos = service.getAll();
        System.out.println("==================");
        for(Alumno a : alumnos){
            System.out.println(a);
        }
        System.out.println("==================");
        return alumnos;
    }

    @PostMapping("addAlumno")
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno al){
        Alumno a = service.createAlumno(al);
        return ResponseEntity.ok(a);
    }

}
