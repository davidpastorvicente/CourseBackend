package com.backend.course.controllers;

import com.backend.course.mappers.ProfesorMapper;
import com.backend.course.models.Profesor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private final ProfesorMapper profesorMapper;

    public ProfesorController(ProfesorMapper profesorMapper) {
        this.profesorMapper = profesorMapper;
    }

    @GetMapping
    public Map<Integer, String> getAll() {
        return profesorMapper.findAll().stream()
                .collect(Collectors.toMap(Profesor::getId, Profesor::getNombreCompleto));
    }
}
