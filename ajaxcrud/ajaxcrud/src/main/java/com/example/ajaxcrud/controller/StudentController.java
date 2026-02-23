package com.example.ajaxcrud.controller;
import com.example.ajaxcrud.model.Student;
import com.example.ajaxcrud.repository.StudentRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository repo;
    
    public StudentController(StudentRepository repo){
        this.repo = repo;
    }

    //CREATE
    @PostMapping
    public Student add(@Valid @RequestBody Student s){
        return repo.save(s);
    }

    //READ
    @GetMapping
    public List<Student> all(){
        return repo.findAll();
    }

    //UPDATE
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,@RequestBody Student s){
        s.setId(id);
        return repo.save(s);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }
}
