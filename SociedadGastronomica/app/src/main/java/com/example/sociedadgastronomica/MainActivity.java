package com.example.sociedadgastronomica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sociedadgastronomica.Modelos.Consumicion;
import com.example.sociedadgastronomica.Modelos.Producto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import sociedadgastronomica.R;
import sociedadgastronomica.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListView listView;
    TextView precioTotalView,precioPersona;
    EditText numPersonas;
    private static final int SHOW_SUBACTIVITY = 1;
    TravelPointsApplication tpa;
    ArrayAdapter<Consumicion> todoItemsAdapter;
    double precioTotalPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Estas 3 lineas de codigo siempre lo primero
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        listView = (ListView) findViewById(R.id.listview);
        tpa = (TravelPointsApplication)getApplicationContext();

        tpa.productos.add(new Producto("Coca",15));
        tpa.productos.add(new Producto("Marihuana",5));
        tpa.productos.add(new Producto("Poper",12));

        todoItemsAdapter = new ArrayAdapter<Consumicion>(this, R.layout.row_layout, R.id.listText, tpa.consumiciones);

        listView.setAdapter(todoItemsAdapter);


        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        ConsumicionActivity.class);
                startActivityForResult(intent, SHOW_SUBACTIVITY);
            }
        });
        numPersonas = (EditText) findViewById(R.id.numPersonas);
        numPersonas.setText(String.format("%s", 1));
        precioTotalView = (TextView)findViewById(R.id.precioTotal);
        precioTotalPagar =precioTotal();
        precioTotalView.setText(String.format("%s", precioTotalPagar));
        precioPersona = (TextView)findViewById(R.id.precioPersona);

        numPersonas.addTextChangedListener(new TextWatcher() {
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
                    numPersonas.setError("Introduce un n??mero");
                } else {
                    int num = Integer.parseInt(editable.toString());
                    precioPersona.setText(String.format("%s", precioTotalPagar/num));
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            todoItemsAdapter.notifyDataSetChanged();
            precioTotalView.setText(""+precioTotal());
            int num = Integer.parseInt(numPersonas.getText().toString());
            precioPersona.setText(""+precioTotalPagar/num);
        }
    }
    protected double precioTotal(){
        precioTotalPagar = 0;
        for(Consumicion c : tpa.consumiciones){
            precioTotalPagar+=c.getProducto().getPrecio()*c.getCantidad();
        }
        return precioTotalPagar;
    }

    public void mostrarProductos(View view){
        Intent intent = new Intent(getApplicationContext(), ProductosActivity.class);
        startActivityForResult(intent, SHOW_SUBACTIVITY);
    }

    public void limpiar(View view){
        tpa.consumiciones.clear();
        todoItemsAdapter.notifyDataSetChanged();
    }
}