package com.backend.course.controllers;

import com.backend.course.models.Profesor;
import com.backend.course.repositories.ProfesorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/profesores")
public class ProfesorController {
    private final ProfesorRepository profeRepo;

    public ProfesorController(ProfesorRepository profeRepo) {
        this.profeRepo = profeRepo;
    }

    @GetMapping
    public List<Profesor> getProfesores() {
        return profeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Profesor getProfesor(@PathVariable long id) {
        return profeRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public long postProfesor(@RequestBody Profesor profe) {
        return profeRepo.save(profe).getId();
    }
}
