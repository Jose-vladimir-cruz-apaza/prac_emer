package com.emergentes2.ejercicio3;
public class Productos {
    private String nombre;
    private String productos[];
    private String existencia;
    private String precio;

    public Productos() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProductos(String[] productos) {
        this.productos = productos;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getProductos() {
        return productos;
    }

    public String getExistencia() {
        return existencia;
    }

    public String getPrecio() {
        return precio;
    }
    
}
