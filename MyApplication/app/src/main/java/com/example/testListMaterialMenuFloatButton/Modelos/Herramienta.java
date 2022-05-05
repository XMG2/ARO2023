package com.example.testListMaterialMenuFloatButton.Modelos;

import com.parse.ParseClassName;
import com.parse.ParseObject;
@ParseClassName("Herramienta")
public class Herramienta extends ParseObject {
    public Herramienta(){

    }

    public Herramienta(String nombre, String descripcion, int cantidad, String funcion) {
        put("Nombre",nombre);
        put("Descripcion",descripcion);
        put("Funcion",funcion);
        put("Cantidad",cantidad);
    }
    public void setNombre(String nombre){
        put("Nombre",nombre);
    }
    public String getNombre(){
        return getString("Nombre");
    }
    public void setDescripcion(String descripcion){
        put("Descripcion",descripcion);
    }
    public String getDescripcion(){
        return getString("Descripcion");
    }
    public String getFuncion() {
        return getString("Funcion");
    }

    public void setFuncion(String funcion) {
        put("Funcion",funcion);
    }
    public void setCantidad(int cantidad){
        put("Cantidad",cantidad);
    }
    public int getCantidad(){
        return getInt("Cantidad");
    }
}
