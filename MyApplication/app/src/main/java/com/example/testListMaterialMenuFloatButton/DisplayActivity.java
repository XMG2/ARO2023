package com.example.testListMaterialMenuFloatButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TableLayout;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.ElementoProducido;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;
import com.google.android.material.tabs.TabLayout;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

public class DisplayActivity extends AppCompatActivity {
    private ElementosDeViajeApp eva;
    private Herramienta herramienta1;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TabLayout tabLayout = findViewById(R.id.tabs);
        eva = (ElementosDeViajeApp) getApplicationContext();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String idElemento = bundle.getString("idElemento");
        String tipo = bundle.getString("tipo");
        int position = bundle.getInt("position");
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (tipo){
            case "HERRAMIENTA":
                ParseQuery<Herramienta> query = ParseQuery.getQuery("Herramienta");
                query.getInBackground(""+idElemento, new GetCallback<Herramienta>() {
                    public void done(Herramienta herramienta, ParseException e) {
                        if (e == null) {
                            System.out.println(herramienta.getNombre());
                            fragmentManager.beginTransaction()
                                    .replace(R.id.fragmentContainerView,new HerramientaDisplayFragment(herramienta),null)
                                    .setReorderingAllowed(true).commit();
                        } else {
                            System.out.println("-------------\nAlgo ha ido mal\n---------");
                            System.out.println(e);
                        }
                    }
                });

                break;
            case "ELEMENTOPRODUCIDO":
                ParseQuery<ElementoProducido> query3 = ParseQuery.getQuery("ElementoProducido");
                query3.getInBackground(""+idElemento, new GetCallback<ElementoProducido>() {
                    public void done(ElementoProducido producido, ParseException e) {
                        if (e == null) {
                            tabLayout.getTabAt(1).view.setVisibility(View.GONE);//ponemos el segundo a tab invisible
                            fragmentManager.beginTransaction()
                                    .replace(R.id.fragmentContainerView,new ProducidoDisplayFragment(producido,eva.elementoList,position),null)
                                    .setReorderingAllowed(true).commit();
                        } else {
                            System.out.println("-------------\nAlgo ha ido mal\n---------");
                            System.out.println(e);
                        }
                    }
                });
                break;
            case "MATERIAPRIMA":
                System.out.println("--------------"+idElemento);
                ParseQuery<MateriaPrima> query2 = ParseQuery.getQuery("MateriaPrima");
                query2.getInBackground(""+idElemento, new GetCallback<MateriaPrima>() {

                    public void done(MateriaPrima materia, ParseException e) {
                        if (e == null) {
                            System.out.println(materia.getNombre());

                            fragmentManager.beginTransaction()
                                    .replace(R.id.fragmentContainerView,new MateriaPrimaDisplayFragment(materia),null)
                                    .setReorderingAllowed(true).commit();
                        } else {
                            System.out.println("-------------\nAlgo ha ido mal\n---------");
                            System.out.println(e);
                        }
                    }
                });
                break;

        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tabLayout.getSelectedTabPosition()){
                    case 0:
                        switch (tipo){
                            case "HERRAMIENTA":
                                ParseQuery<Herramienta> query = ParseQuery.getQuery("Herramienta");
                                query.getInBackground(""+idElemento, new GetCallback<Herramienta>() {
                                    public void done(Herramienta herramienta, ParseException e) {
                                        if (e == null) {
                                            fragmentManager.beginTransaction()
                                                    .replace(R.id.fragmentContainerView,new HerramientaDisplayFragment(herramienta),null)
                                                    .setReorderingAllowed(true).commit();
                                        } else {
                                            System.out.println("-------------\nAlgo ha ido mal\n---------");
                                            System.out.println(e);
                                        }
                                    }
                                });
                                break;
                            case "ELEMENTOPRODUCIDO":
                                ParseQuery<ElementoProducido> query3 = ParseQuery.getQuery("ElementoProducido");
                                query3.getInBackground(""+idElemento, new GetCallback<ElementoProducido>() {
                                    public void done(ElementoProducido producido, ParseException e) {
                                        if (e == null) {
                                            tabLayout.getTabAt(1).view.setVisibility(View.GONE);//ponemos el segundo a tab invisible
                                            fragmentManager.beginTransaction()
                                                    .replace(R.id.fragmentContainerView,new ProducidoDisplayFragment(producido,eva.elementoList,position),null)
                                                    .setReorderingAllowed(true).commit();
                                        } else {
                                            System.out.println("-------------\nAlgo ha ido mal\n---------");
                                            System.out.println(e);
                                        }
                                    }
                                });
                                break;
                            case "MATERIAPRIMA":
                                ParseQuery<MateriaPrima> query2 = ParseQuery.getQuery("MateriaPrima");
                                query2.getInBackground(""+idElemento, new GetCallback<MateriaPrima>() {
                                    public void done(MateriaPrima materia, ParseException e) {
                                        if (e == null) {
                                            fragmentManager.beginTransaction()
                                                    .replace(R.id.fragmentContainerView,new MateriaPrimaDisplayFragment(materia),null)
                                                    .setReorderingAllowed(true).commit();
                                        } else {
                                            System.out.println("-------------\nAlgo ha ido mal\n---------");
                                            System.out.println(e);
                                        }
                                    }
                                });
                                break;
                        }
                        break;
                    case 1:
                        switch (tipo){
                            case "HERRAMIENTA":
                                ParseQuery<Herramienta> query = ParseQuery.getQuery("Herramienta");
                                query.getInBackground(""+idElemento, new GetCallback<Herramienta>() {
                                    public void done(Herramienta herramienta, ParseException e) {
                                        if (e == null) {
                                            fragmentManager.beginTransaction()
                                                    .replace(R.id.fragmentContainerView,new HerramientaModifyFragment(herramienta,eva.elementoList,position),null)
                                                    .setReorderingAllowed(true).commit();
                                        } else {
                                            System.out.println("-------------\nAlgo ha ido mal\n---------");
                                            System.out.println(e);
                                        }
                                    }
                                });

                                break;
                            case "MATERIAPRIMA":

                                ParseQuery<MateriaPrima> query2 = ParseQuery.getQuery("MateriaPrima");
                                query2.getInBackground(""+idElemento, new GetCallback<MateriaPrima>() {
                                    public void done(MateriaPrima materia, ParseException e) {
                                        if (e == null) {
                                            fragmentManager.beginTransaction()
                                                    .replace(R.id.fragmentContainerView,new MateriaPrimaModifyFragment(materia,eva.elementoList,position),null)
                                                    .setReorderingAllowed(true).commit();
                                        } else {
                                            System.out.println("-------------\nAlgo ha ido mal\n---------");
                                            System.out.println(e);
                                        }
                                    }
                                });
                                break;

                        }
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    public void volver(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}