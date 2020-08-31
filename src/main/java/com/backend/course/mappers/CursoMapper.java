package com.backend.course.mappers;

import com.backend.course.models.Curso;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoMapper {

    @Select("SELECT * FROM \"Cursos\"")
    List<Curso> findAll();

    @Insert("INSERT INTO \"Cursos\"(\"Titulo\", \"Horas\", \"Profesor\", \"Nivel\", \"Activo\") " +
            "VALUES (#{titulo}, #{horas}, #{profesor}, #{nivel}, #{activo})")
    void addCurso(Curso curso);
}
