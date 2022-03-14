package com.example.testListMaterialMenuFloatButton.Modelos;

public  class Tamano{
    private enum Tipo {CILINDRO,CUBICO}
    Double diametro,alto,ancho,largo;
    Tipo tipo;
    public Tamano(Double diametro, Double largo) {
        this.diametro = diametro;
        this.largo = largo;
        this.tipo = Tipo.CILINDRO;
    }

    public Tamano(Double alto, Double ancho, Double largo) {
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.tipo = Tipo.CUBICO;
    }
    public double volumen(){
        switch (tipo) {
            case CUBICO:
                return alto * ancho * largo;

            case CILINDRO:
                return Math.PI * (diametro * diametro / 4.0) * 2.0 * largo;

        }
        return 0;
    }

    public Double getDiametro() {
        return diametro;
    }

    public void setDiametro(Double diametro) {
        this.diametro = diametro;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        if (tipo == Tipo.CILINDRO) {
            return "Tamaño(" +
                    "diametro=" + diametro +
                    ", largo=" + largo +
                    ')';
        } else {
            return "Tamaño(" +
                    "alto=" + alto +
                    ", ancho=" + ancho +
                    ", largo=" + largo +
                    ')';
        }
    }

}
