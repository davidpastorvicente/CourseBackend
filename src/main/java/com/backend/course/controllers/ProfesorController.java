package com.backend.course.controllers;

import com.backend.course.mappers.ProfesorMapper;
import com.backend.course.models.Profesor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private ProfesorMapper profesorMapper;

    public ProfesorController(ProfesorMapper profesorMapper) {
        this.profesorMapper = profesorMapper;
    }

    @GetMapping
    public List<Profesor> getAll() {
        return profesorMapper.findAll();
    }
}
