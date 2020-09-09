package com.backend.course.models;

import lombok.Data;

@Data
public class Temario {
    private String nombre;
    private String url;

    public Temario(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }
}
