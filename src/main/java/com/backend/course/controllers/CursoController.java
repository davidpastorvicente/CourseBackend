package com.backend.course.controllers;

import com.backend.course.mappers.CursoMapper;
import com.backend.course.models.Curso;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Curso addCurso(@RequestBody Curso curso) {
        cursoMapper.addCurso(curso);
        return curso;
    }

    @PutMapping
    public void addTemario(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) throws IOException {
        cursoMapper.addTemario(file.getBytes(), id);
    }

    @DeleteMapping("/{cursoId}")
    public void deleteCurso(@PathVariable int cursoId) {
        cursoMapper.deleteCurso(cursoId);
    }
}
