package com.backend.course.mappers;

import com.backend.course.models.Profesor;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorMapper {

    @Select("select * from \"Profesores\"")
    List<Profesor> findAll();
}
