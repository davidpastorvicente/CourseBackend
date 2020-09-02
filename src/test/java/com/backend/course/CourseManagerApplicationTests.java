package com.backend.course;

import com.backend.course.controllers.CursoController;
import com.backend.course.mappers.CursoMapper;
import com.backend.course.models.Curso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CourseManagerApplicationTests {
    @Resource
    CursoController cursoController;

    @Resource
    CursoMapper cursoMapper;

    @Test
    void addCurso() {
        int size = cursoController.getAll().size();
        Curso curso = new Curso();
        curso.setTitulo("Prueba");
        curso.setHoras(20);
        curso.setProfesor(1);
        curso.setNivel("Básico");
        curso.setActivo(true);

        curso = cursoController.addCurso(curso);
        Assertions.assertEquals(size + 1, cursoController.getAll().size());

        cursoMapper.deleteCurso(curso);
        Assertions.assertEquals(size, cursoController.getAll().size());
    }

}
