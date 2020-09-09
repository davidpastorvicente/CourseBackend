package com.backend.course.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int horas;
    private Nivel nivel;
    private boolean activo;
    private String temario;

    @ManyToOne
    private Profesor profesor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemario(String temario) {
        this.temario = temario;
    }

    @Override
    public String toString() {
        return "Curso {" +
                "id = " + id +
                ", titulo = '" + titulo + '\'' +
                ", horas = " + horas +
                ", profesor = " + profesor +
                ", nivel = " + nivel +
                ", activo = " + activo +
                ", temario = " + temario +
                '}';
    }
}
