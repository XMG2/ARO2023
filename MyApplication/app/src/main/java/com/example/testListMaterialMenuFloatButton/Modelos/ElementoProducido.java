package com.example.testListMaterialMenuFloatButton.Modelos;

public class ElementoProducido {
    String compuesto;
    Tamano tamano;
    float precio;

    public ElementoProducido(String compuesto, Double alto,Double ancho, Double largo, float precio) {
        this.compuesto = compuesto;
        this.tamano = new Tamano(alto,ancho,largo);
        this.precio = precio;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
