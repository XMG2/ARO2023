package com.example.testListMaterialMenuFloatButton.Modelos;

public class Elemento {
    String nombre;
    String descripcion;
    int cantidad;
    enum Tipo{MATERIAPRIMA,HERRAMIENTA,ELEMENTOPRODUCIDO}
    Tipo tipo;
    public Elemento(String nombre, String descripcion, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Elemento(String nombre, String descripcion, int cantidad, Tipo tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Tipo getTipo() {
        return tipo;
    }
    public String getTipo(int i){
        return ""+tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "" + nombre + ":\n" + descripcion + "\ncantidad: "+cantidad;
    }

}
