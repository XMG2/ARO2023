package com.example.sociedadgastronomica;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import sociedadgastronomica.R;
import com.example.sociedadgastronomica.Modelos.Consumicion;
import com.example.sociedadgastronomica.Modelos.Producto;

public class NuevaConsumicionActivity extends AppCompatActivity {
    String nombre;
    double precio;
    int posicion;
    TravelPointsApplication tpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        posicion = bundle.getInt("posicion");
        setContentView(R.layout.activity_add_consumicion);
        tpa = (TravelPointsApplication)getApplicationContext();
        nombre = tpa.productos.get(posicion).getNombre();
        precio = tpa.productos.get(posicion).getPrecio();
        TextView textView1 =((TextView) findViewById(R.id.NombreConsumicion));
        textView1.setTextSize(40);
        textView1.setText(nombre);

        TextView textView2 =((TextView) findViewById(R.id.precioConsumicion));
        textView2.setTextSize(40);
        textView2.setText(String.format("%s", precio));

        TextView textView3 =((TextView) findViewById(R.id.cantidad));
        textView3.setTextSize(40);
        textView3.setText(String.format("%s", 1));
    }

    public void addConsumicion(View view){

        Producto producto = tpa.productos.get(posicion);
        EditText editText3 = (EditText) findViewById(R.id.cantidad);
        String cant = editText3.getText().toString();


        if(cant.length()>=1) {
            int cantidad = Integer.parseInt(cant);
            Consumicion consumicion = new Consumicion(producto, cantidad);
            //System.out.println(consumicion.toString());
            tpa.consumiciones.add(consumicion);
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        } else {
            editText3.setError("Numero invalido");
        }
    }
    public void cancelar(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

}