package com.example.testListMaterialMenuFloatButton.Modelos;

public class MateriaPrima extends Elemento {
    Tamano tamano;
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
        ////
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
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return  nombre +
                "\nDescripción:" + descripcion+
                "\nCantidad="+cantidad ;
    }
}
