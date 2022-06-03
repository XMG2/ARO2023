package com.example.sociedadgastronomica;

import android.app.Application;

import com.example.sociedadgastronomica.Modelos.Consumicion;
import com.example.sociedadgastronomica.Modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class
TravelPointsApplication extends Application {


    public List<Consumicion> consumiciones = new ArrayList<>();
    public List<Producto> productos = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }




}
