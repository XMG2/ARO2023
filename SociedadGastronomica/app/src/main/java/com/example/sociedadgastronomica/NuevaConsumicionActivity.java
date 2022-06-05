package com.example.sociedadgastronomica;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import sociedadgastronomica.R;
import com.example.sociedadgastronomica.Modelos.Consumicion;
import com.example.sociedadgastronomica.Modelos.Producto;

public class NuevaConsumicionActivity extends AppCompatActivity {
    String nombre;
    double precio;
    int posicion,cantidad;
    TravelPointsApplication tpa;
    EditText editText;
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

        editText =((EditText) findViewById(R.id.cantidad));
        editText.setTextSize(40);
        editText.setHint(String.format("%s", 1));
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Compruebo si hay algo antes de operar con el valor
                if(editable.toString().length()<1) {
                    editText.setError("Introduce un número");
                } else {
                    cantidad = Integer.parseInt(editText.getText().toString());
                }
            }
        });
    }

    public void addConsumicion(View view){
        Producto producto = tpa.productos.get(posicion);
        //String cant = editText.getText().toString();

        Consumicion consumicion = new Consumicion(producto, cantidad);
        tpa.consumiciones.add(consumicion);
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();

    }
    public void cancelar(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

}