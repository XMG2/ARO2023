package com.example.sociedadgastronomicaapp;

import android.app.Application;

import com.example.sociedadgastronomicaapp.Modelos.Consumicion;
import com.example.sociedadgastronomicaapp.Modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class ElementosDeViajeApp extends Application{
    public List<Consumicion> consumiciones = new ArrayList<>();
    public List<Producto> productos = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
