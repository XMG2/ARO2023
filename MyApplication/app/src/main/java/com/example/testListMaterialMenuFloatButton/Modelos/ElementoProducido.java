package com.example.testListMaterialMenuFloatButton.Modelos;

public class ElementoProducido extends Elemento{
    String compuesto;
    Tamano tamano;
    Double precio;
    enum TipoLlanta{TIPO1,TIPO2,TIPO3,TIPO4,TIPO5,TIPO6,TIPO7,TIPO8,TIPO9};
    TipoLlanta llanta;
    /*public ElementoProducido(String compuesto, Double alto,Double ancho, Double largo, Double precio) {
        this.compuesto = compuesto;
        this.tamano = new Tamano(alto,ancho,largo);
        this.precio = precio;
    }*/

    public ElementoProducido(String nombre, String descripcion, int cantidad, String compuesto, Double precio) {
        super(nombre, descripcion, cantidad,Tipo.ELEMENTOPRODUCIDO);
        this.compuesto = compuesto;
        this.precio = precio;
    }
    public ElementoProducido(String nombre, String descripcion, int cantidad, String compuesto,TipoLlanta tipo) {
        super(nombre, descripcion, cantidad,Tipo.ELEMENTOPRODUCIDO);
        this.compuesto = compuesto;
        this.llanta = tipo;
    }

    public String getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(String compuesto) {
        this.compuesto = compuesto;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
