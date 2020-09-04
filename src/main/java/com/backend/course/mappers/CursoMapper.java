package com.backend.course.mappers;

import com.backend.course.models.Curso;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoMapper {

    @Select("SELECT * FROM \"Cursos\"")
    List<Curso> getAll();

    @Insert("INSERT INTO \"Cursos\"(\"Titulo\", \"Horas\", \"Profesor\", \"Nivel\", \"Activo\") " +
            "VALUES (#{titulo}, #{horas}, #{profesor}, #{nivel}, #{activo})")
    void addCurso(Curso curso);

    @Update("UPDATE \"Cursos\" SET \"Temario\" = #{file} WHERE \"id\" = #{id}")
    void addTemario(byte[] file, int id);

    @Delete("DELETE FROM \"Cursos\" WHERE \"id\" = #{id}")
    void deleteCurso(int id);
}
