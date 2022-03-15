package com.example.testListMaterialMenuFloatButton;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.ElementoProducido;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;

public class DisplayActivity extends AppCompatActivity {

    int position;
    ElementosDeViajeApp eva;
    ElementoProducido producido;
    MateriaPrima prima;
    Herramienta herramienta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eva = (ElementosDeViajeApp)getApplicationContext();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        position = bundle.getInt("position");
        System.out.println(eva.elementoList.get(position).getClass().toString());

        setContentView(R.layout.activity_display);


    }

    public void goBack(View view){
        finish();
    }

}