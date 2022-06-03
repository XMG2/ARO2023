package com.example.sociedadgastronomica.Modelos;

public class Consumicion {

    Producto producto;
    int cantidad;
    double precio;

    public Consumicion(){
    }

    public Consumicion(Producto producto,int cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.precio= producto.getPrecio()*cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        setPrecio(cantidad);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int cantidad) {
        this.precio = producto.precio*cantidad;
    }

    @Override
    public String toString() {
        return this.producto.getNombre()+"x"+this.cantidad+"("+this.producto.getPrecio()+")";
    }
}