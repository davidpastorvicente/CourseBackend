package com.backend.course.controllersTests;

import org.junit.jupiter.api.*;
import com.backend.course.controllers.CursoController;
import com.backend.course.controllers.ProfesorController;
import com.backend.course.models.Curso;
import com.backend.course.models.Nivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CursoControllerTests {
    @Autowired
    CursoController cursoController;

    @Autowired
    ProfesorController profesorController;

    private static long id;
    private static int initSize;

    @Test
    @Order(1)
    void addCursos() {
        initSize = cursoController.getCursos().size();

        Curso curso = new Curso();
        curso.setTitulo("Prueba");
        curso.setHoras(20);
        curso.setNivel(Nivel.Intermedio);
        curso.setActivo(true);
        curso.setProfesor(profesorController.getProfesor(1));

        id = cursoController.postCurso(curso);
        List<Curso> newList = cursoController.getCursos();

        Assertions.assertEquals(initSize + 1, newList.size());
        Assertions.assertEquals(curso, cursoController.getCurso(id));
    }
    
    @Test
    @Order(2)
    void removeCursos() {
        cursoController.deleteCurso(id);
        List<Curso> newList = cursoController.getCursos();

        Assertions.assertEquals(initSize, newList.size());
        Assertions.assertThrows(NoSuchElementException.class, () -> cursoController.getCurso(id));
    }
}
