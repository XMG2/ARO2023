package com.example.sociedadgastronomica.Modelos;

public class Producto {
    String nombre;
    double precio;


    public Producto(){
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return  this.precio;
    }

    public void setPrecio(double precio) {
        this.precio=precio;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.getNombre()+" "+this.getPrecio()+"€";
    }
}
