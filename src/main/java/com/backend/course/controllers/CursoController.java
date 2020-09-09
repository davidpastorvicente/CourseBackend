package com.backend.course.controllers;

import com.backend.course.models.Curso;
import com.backend.course.repositories.CursoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/cursos")
public class CursoController {
    private final CursoRepository cursoRepo;

    public CursoController(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    @GetMapping
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Curso getCurso(@PathVariable long id) {
        return cursoRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public long postCurso(@RequestBody Curso curso) {
        return cursoRepo.save(curso).getId();
    }

    @PutMapping("/{id}")
    public void putCurso(@PathVariable Long id, @RequestBody Curso curso) {
        if(cursoRepo.existsById(id)) {
            curso.setId(id);
            cursoRepo.save(curso);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable long id) {
        cursoRepo.deleteById(id);
    }

    public void addTemario(Long id, String urlTemario) {
        Curso curso = cursoRepo.findById(id).orElseThrow();
        curso.setTemario(urlTemario);
        cursoRepo.save(curso);
    }
}
