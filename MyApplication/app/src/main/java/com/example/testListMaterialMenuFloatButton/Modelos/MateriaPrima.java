package com.example.testListMaterialMenuFloatButton.Modelos;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("MateriaPrima")
public class MateriaPrima extends  ParseObject {
    public MateriaPrima(){

    }
    /*Tamano tamano;
    public enum Compuesto{ALUMINIO,ACERO,TITANIO,CARBONO,NETHERITE,NUKA_COLA,VIBRANIUM}
    Compuesto compuesto;
    public MateriaPrima(String nombre, String descripcion,Compuesto compuesto, Double diametro, Double largo,int cantidad) {

        super(nombre, descripcion,cantidad,Tipo.MATERIAPRIMA);
        this.compuesto = compuesto;
        this.tamano = new Tamano(diametro,largo);
    }

    public MateriaPrima(String nombre, String descripcion, Compuesto compuesto,Double alto,Double ancho, Double largo,int cantidad) {
        super(nombre, descripcion,cantidad,Tipo.MATERIAPRIMA);
        this.compuesto = compuesto;
        this.tamano = new Tamano(alto,ancho,largo);

    }

    public Compuesto getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(Compuesto compuesto) {
        this.compuesto = compuesto;
    }
    public Double getVolumen(){
        return tamano.volumen();
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {

    }


    @Override
    public String toString() {
        return  nombre +
                "\nDescripción:" + descripcion+
                "\nCantidad="+cantidad ;
    }*/
    public MateriaPrima(String nombre, String descripcion, String compuesto,Double alto,Double ancho, Double largo,int cantidad){
        put("Nombre",nombre);
        put("Descripcion",descripcion);
        put("Compuesto",compuesto);
        put("Tamano",alto*ancho*largo);
        put("Cantidad",cantidad);
    }
    public MateriaPrima(String nombre, String descripcion,String compuesto, Double diametro, Double largo,int cantidad){
        put("Nombre",nombre);
        put("Descripcion",descripcion);
        put("Compuesto",compuesto);
        put("Tamano",diametro*largo);
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
    public String getCompuesto() {
        return getString("Compuesto");
    }

    public void setCompuesto(String compuesto) {
        put("Compuesto",compuesto);
    }

    public double getTamano() {
        return getDouble("Tamano");
    }
    public double getVolumen(){
        return getDouble("Tamano");
    }
    public void setTamano(Double alto,Double ancho, Double largo) {
        put("Tamano",alto*ancho*largo);
    }
    public void setCantidad(int cantidad){
        put("Cantidad",cantidad);
    }
    public int getCantidad(){
        return getInt("Cantidad");
    }

}
