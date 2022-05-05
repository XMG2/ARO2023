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
        ParseQuery<Herramienta> query = ParseQuery.getQuery("Herramienta");
        query.findInBackground(new FindCallback<Herramienta>() {
            public void done(List<Herramienta> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                    for(int i = 0; i< scoreList.size();i++){
                        elementoList.add(new Elemento(scoreList.get(i).getNombre(),scoreList.get(i).getDescripcion(),scoreList.get(i).getCantidad(),"HERRAMIENTA",scoreList.get(i).getObjectId()));
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        ParseQuery<MateriaPrima> query2 = ParseQuery.getQuery("MateriaPrima");
        query2.findInBackground(new FindCallback<MateriaPrima>() {
            public void done(List<MateriaPrima> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                    for(int i = 0; i< scoreList.size();i++){

                        elementoList.add(new Elemento(scoreList.get(i).getNombre(),scoreList.get(i).getDescripcion(),scoreList.get(i).getCantidad(),"MATERIAPRIMA",scoreList.get(i).getObjectId()));
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        ParseQuery<ElementoProducido> query3 = ParseQuery.getQuery("ElementoProducido");
        query3.findInBackground(new FindCallback<ElementoProducido>() {
            public void done(List<ElementoProducido> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                    for(int i = 0; i< scoreList.size();i++){

                        elementoList.add(new Elemento(scoreList.get(i).getNombre(),scoreList.get(i).getDescripcion(),scoreList.get(i).getCantidad(),"ELEMENTOPRODUCIDO",scoreList.get(i).getObjectId()));
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

    }
/*
Para saber de que tipo es cada elemento almacenado en la lista usar "if(t instanceof XXXXXX){...}"
*/

}
