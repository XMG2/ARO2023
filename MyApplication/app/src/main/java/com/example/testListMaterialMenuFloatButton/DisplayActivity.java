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

public class DisplayActivity extends AppCompatActivity {
    private ElementosDeViajeApp eva;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);




        eva = (ElementosDeViajeApp) getApplicationContext();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int position = bundle.getInt("position");
        Elemento elemento = eva.elementoList.get(position);
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (elemento.getTipo(1)){
            case "HERRAMIENTA":

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,new HerramientaDisplayFragment((Herramienta) elemento),null)
                        .setReorderingAllowed(true).commit();
                break;
            case "ELEMENTOPRODUCIDO":

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,new ProducidoDisplayFragment((ElementoProducido) elemento),null)
                        .setReorderingAllowed(true).commit();
                break;
            case "MATERIAPRIMA":


                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,new MateriaPrimaDisplayFragment((MateriaPrima) eva.elementoList.get(position)),null)
                        .setReorderingAllowed(true).commit();

                break;

        }
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tabLayout.getSelectedTabPosition()){
                    case 0:
                        System.out.println("heyyy");
                        break;
                    case 1:
                        System.out.println("asdfasdfasd");
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
        //System.out.println("llego");

        //System.out.println("asdfasdf: "+i);
        /*TabLayout.Tab tab1 = tabLayout.getTabAt(0);
        TabLayout.Tab tab2 = tabLayout.getTabAt(2);
        if(tab1.isSelected()){
            System.out.println("heyyyy");
        }else if(tab2.isSelected()){
            System.out.println("ooooooooooo");
        }*/




    }
    public void volver(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }
}