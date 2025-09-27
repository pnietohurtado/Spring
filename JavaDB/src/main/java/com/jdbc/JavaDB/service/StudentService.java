package com.jdbc.JavaDB.service;

import com.jdbc.JavaDB.models.Student;
import com.jdbc.JavaDB.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repo;

    public StudentRepository getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }

    public void addStudents(Student student){
        repo.save(student);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
