package com.example.sociedadgastronomica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sociedadgastronomica.Modelos.Consumicion;
import com.example.sociedadgastronomica.Modelos.Producto;

import sociedadgastronomica.R;

public class NuevoProductoActivity extends AppCompatActivity {
    String nombre;
    double precio;
    int posicion;
    EditText editText1,editText2;
    TravelPointsApplication tpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        posicion = bundle.getInt("posicion");
        setContentView(R.layout.activity_nuevo_producto);
        editText1 = (EditText) findViewById(R.id.nombreProducto);
        editText2 = (EditText) findViewById(R.id.precioProducto);
        tpa = (TravelPointsApplication)getApplicationContext();
        if(posicion !=-1) {
            nombre = tpa.productos.get(posicion).getNombre();
            precio = tpa.productos.get(posicion).getPrecio();

            editText1.setText(nombre);

            editText2.setText(String.format("%s", precio));
        } else{
            nombre = "Inserte Nombre";
            precio = 1;
            editText1.setText(nombre);
            editText2.setText(String.format("%s", precio));
        }
    }
    public void addProducto(View view){
        double pre;
        String nom,prec;
        if(posicion!=-1) {
            pre =Double.parseDouble( editText2.getText().toString());
            if(pre>0) {
                Producto producto = tpa.productos.get(posicion);
                producto.setPrecio(pre);
                producto.setNombre(editText1.getText().toString());
                //tpa.productos.set(posicion,producto);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }else{
                editText2.setError("Precio invalido");
            }
        } else {
            nom =editText1.getText().toString();
            prec = editText2.getText().toString();
            if(nom.length()>0&&prec.length()>0) {
                pre = Double.parseDouble( editText2.getText().toString());
                Producto producto = new Producto(nom, pre);
                tpa.productos.add(producto);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }else if(nom.length()<1){
                editText1.setError("Nombre invalido");
            }else{
                editText2.setError("Precio invalido");
            }
        }
    }
    public void cancelar(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

}