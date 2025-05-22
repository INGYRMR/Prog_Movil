package com.example.proyecto2;
public class Tarea {
    private String titulo;
    private boolean completada;

    public Tarea(String titulo) {
        this.titulo = titulo;
        this.completada = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaCompletada() {
        return completada;
    }

    public void cambiarEstado() {
        this.completada = !this.completada;
    }
}