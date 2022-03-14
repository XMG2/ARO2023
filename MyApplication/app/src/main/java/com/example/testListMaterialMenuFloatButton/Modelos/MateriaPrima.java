package com.example.testListMaterialMenuFloatButton.Modelos;

public class MateriaPrima extends Elemento {
    String compuesto;
    Tamano tamano;
    public MateriaPrima(String nombre, String descripcion,String compuesto, Double diametro, Double largo,int cantidad) {
        super(nombre, descripcion,cantidad,Tipo.MATERIAPRIMA);
        this.compuesto = compuesto;
        this.tamano = new Tamano(diametro,largo);
    }

    public MateriaPrima(String nombre, String descripcion, String compuesto,Double alto,Double ancho, Double largo,int cantidad) {
        super(nombre, descripcion,cantidad,Tipo.MATERIAPRIMA);
        this.compuesto = compuesto;
        this.tamano = new Tamano(alto,ancho,largo);
    }

    public String getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(String compuesto) {
        this.compuesto = compuesto;
    }
    public Double getVolumen(){
        return tamano.volumen();
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return  nombre +
                "\nDescripción:" + descripcion+
                "\nCantidad="+cantidad ;
    }
}
