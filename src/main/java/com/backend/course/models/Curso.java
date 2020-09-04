package com.backend.course.models;

public class Curso {
    private int id;
    private String titulo;
    private int horas;
    private int profesor;
    private String nivel;
    private boolean activo;
    private byte[] temario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public byte[] getTemario() {
        return temario;
    }

    public void setTemario(byte[] temario) {
        this.temario = temario;
    }

    @Override
    public String toString() {
        return "Curso {" +
                "titulo='" + titulo + '\'' +
                ", horas=" + horas +
                ", profesor=" + profesor +
                ", nivel='" + nivel + '\'' +
                ", activo=" + activo +
                '}';
    }
}
