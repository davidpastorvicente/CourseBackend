package com.backend.course.controllers;

import com.backend.course.mappers.CursoMapper;
import com.backend.course.models.Curso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private CursoMapper cursoMapper;

    public CursoController(CursoMapper cursoMapper) {
        this.cursoMapper = cursoMapper;
    }

    @GetMapping
    public List<Curso> getAll() {
        return cursoMapper.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCurso(@RequestBody Curso curso) {
        cursoMapper.addCurso(curso);
    }
}
