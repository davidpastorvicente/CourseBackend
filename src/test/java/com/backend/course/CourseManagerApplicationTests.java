package com.backend.course;

import com.backend.course.controllers.CursoController;
import com.backend.course.models.Curso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class CourseManagerApplicationTests {
    @Autowired
    CursoController cursoController;

    @Test
    void crudCurso() {
        List<Curso> prevList = cursoController.getAll();
        Curso curso = new Curso();

        curso.setTitulo("Prueba");
        curso.setHoras(20);
        curso.setProfesor(1);
        curso.setNivel("Básico");
        curso.setActivo(true);

        curso = cursoController.addCurso(curso);
        List<Curso> newList = cursoController.getAll();

        Assertions.assertEquals(prevList.size() + 1, newList.size());
        Assertions.assertEquals("Prueba", newList.get(newList.size() - 1).getTitulo());
        Assertions.assertTrue(newList.stream().anyMatch(c -> c.getTitulo().equals("Prueba")));

        cursoController.deleteCurso(curso.getId());
        newList = cursoController.getAll();

        Assertions.assertEquals(prevList.size(), newList.size());
    }

}
