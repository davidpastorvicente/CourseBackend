package com.backend.course.controllers;

import com.backend.course.mappers.CursoMapper;
import com.backend.course.models.Curso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoMapper cursoMapper;

    public CursoController(CursoMapper cursoMapper) {
        this.cursoMapper = cursoMapper;
    }

    @GetMapping
    public List<Curso> getAll() {
        return cursoMapper.getAll();
    }

    @PostMapping
    @ResponseBody
    public Curso addCurso(@RequestBody Curso curso) {
        cursoMapper.addCurso(curso);
        List<Curso> listCursos = cursoMapper.getAll();
        curso.setId(listCursos.get(listCursos.size() - 1).getId());
        return curso;
    }
}
