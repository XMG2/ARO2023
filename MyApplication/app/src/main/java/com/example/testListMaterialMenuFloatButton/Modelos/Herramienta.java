package com.example.testListMaterialMenuFloatButton.Modelos;

public class Herramienta extends Elemento{
    public enum Funcion{CORTE,SOLDADURA,ATORNILLAR,GOLPE,APRETAR,MEDIR,LIJA}
    Funcion funcion;

    public Herramienta(String nombre, String descripcion, int cantidad, Funcion funcion) {
        super(nombre, descripcion, cantidad,Tipo.HERRAMIENTA);
        this.funcion = funcion;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return nombre + "\nDescripcion:" + descripcion +
                "\nCantidad=" + cantidad +
                "\n" + funcion ;
    }
}
