package com.backend.course.models;

import java.util.Objects;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setTemario(String temario) {
        this.temario = temario;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return horas == curso.horas &&
                activo == curso.activo &&
                Objects.equals(titulo, curso.titulo) &&
                nivel == curso.nivel &&
                Objects.equals(temario, curso.temario) &&
                Objects.equals(profesor, curso.profesor);
    }
}
