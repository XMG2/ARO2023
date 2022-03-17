package com.example.testListMaterialMenuFloatButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;

public class DisplayActivity extends AppCompatActivity {
    private ElementosDeViajeApp eva;
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
                        .replace(R.id.fragmentContainerViewHerramienta,new HerramientaDisplayFragment((Herramienta) eva.elementoList.get(position)),null)
                        .setReorderingAllowed(true).commit();
                break;
            case "ELEMENTOPRODUCIDO":
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerViewHerramienta,new HerramientaDisplayFragment((Herramienta) eva.elementoList.get(position)),null)
                        .setReorderingAllowed(true).commit();
                break;
            case "MATERIAPRIMA":

                break;

        }


    }
    public void volver(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }
}