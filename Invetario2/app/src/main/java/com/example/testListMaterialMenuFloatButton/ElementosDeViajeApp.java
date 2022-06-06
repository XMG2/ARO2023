package com.example.testListMaterialMenuFloatButton;

import android.app.Application;
import android.util.Log;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.ElementoProducido;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class
ElementosDeViajeApp extends Application {

    public List<Elemento> elementoList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(MateriaPrima.class);
        ParseObject.registerSubclass(Herramienta.class);
        ParseObject.registerSubclass(ElementoProducido.class);
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("myAppId") //si no has cambiado APP_ID, sino pon el valor de APP_ID
                .clientKey("empty")
                .server("https://parseservertunombre.herokuapp.com/parse/")   // '/' important after 'parse'
                .build());

    }
}
