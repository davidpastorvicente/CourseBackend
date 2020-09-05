package com.backend.course.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return nombre + ' ' + apellido + " (" + id + ')';
    }
}
