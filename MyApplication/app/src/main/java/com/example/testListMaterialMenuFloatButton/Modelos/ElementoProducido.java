package com.example.testListMaterialMenuFloatButton.Modelos;

import com.parse.ParseClassName;
import com.parse.ParseObject;
@ParseClassName("ElementoProducido")
public class ElementoProducido extends ParseObject {

    public ElementoProducido(){

    }
    public ElementoProducido(String nombre, String descripcion, int cantidad, String compuesto, Double precio) {
        put("Nombre",nombre);
        put("Descripcion",descripcion);
        put("Compuesto",compuesto);
        put("Precio",precio);
        put("Cantidad",cantidad);
    }/*
    public ElementoProducido(String nombre, String descripcion, int cantidad, String compuesto,TipoLlanta tipo) {
        super(nombre, descripcion, cantidad,Tipo.ELEMENTOPRODUCIDO);
        this.compuesto = compuesto;
        this.llanta = tipo;
    }*/
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
    public void setCantidad(int cantidad){
        put("Cantidad",cantidad);
    }
    public int getCantidad(){
        return getInt("Cantidad");
    }
    public String getCompuesto() {
        return getString("Compuesto");
    }
    public void setCompuesto(String compuesto) {
        put("Compuesto",compuesto);
    }

    public Double getPrecio() {
        return getDouble("Precio");
    }

    public void setPrecio(Double precio) {
        put("Precio",precio);
    }

}
