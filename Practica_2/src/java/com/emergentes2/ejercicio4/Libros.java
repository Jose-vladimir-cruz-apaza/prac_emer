package com.emergentes2.ejercicio4;
public class Libros {
    private String titulo;
    private String autor;
    private String resumen;
    private String medio[];

    public Libros() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getResumen() {
        return resumen;
    }

    public String[] getMedio() {
        return medio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setMedio(String[] medio) {
        this.medio = medio;
    }
    
}
