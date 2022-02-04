package com.example.practica1botones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void Ventana1(View view) {
        finish();
    }

    public void Ventana3(View view) {
        Intent intent = new Intent(this,Activity3.class);
        startActivity(intent);
    }
}