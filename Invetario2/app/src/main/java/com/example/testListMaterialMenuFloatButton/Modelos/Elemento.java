package com.example.testListMaterialMenuFloatButton.Modelos;

public class Elemento {
    String nombre;
    String descripcion;
    int cantidad;
    enum Tipo{MATERIAPRIMA,HERRAMIENTA,ELEMENTOPRODUCIDO};
    Tipo tipo;
    String idElemento;

    /*public Elemento(String nombre, String descripcion, int cantidad, Tipo tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }*/
    public Elemento(String nombre, String descripcion, int cantidad, String tipo,String idElemento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.idElemento=idElemento;
        switch (tipo){
            case "MATERIAPRIMA":
                this.tipo=Tipo.MATERIAPRIMA;
                break;
            case "HERRAMIENTA":
                this.tipo=Tipo.HERRAMIENTA;
                break;
            case "ELEMENTOPRODUCIDO":
                this.tipo=Tipo.ELEMENTOPRODUCIDO;
                break;
        }

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

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
        this.idElemento = idElemento;
    }
}
