package com.emergentes.modelo;
public class Vacunas {
    private int id;
    private String nombre;
    private String peso;
    private String talla;
    private String vacuna;
    
    public Vacunas(){
    this.id=0;    
    this.nombre ="";
    this.peso="";
    this.talla="";
    this.vacuna="";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
    
}
