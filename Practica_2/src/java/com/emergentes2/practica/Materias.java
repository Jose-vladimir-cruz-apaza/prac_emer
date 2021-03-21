package com.emergentes2.practica;
public class Materias {
    private String nombre;
    private String apellido;
    private String materias[];

    public Materias() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String[] getMaterias() {
        return materias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }
    
}
