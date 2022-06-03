package com.example.sociedadgastronomica;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sociedadgastronomica.Modelos.Producto;

import sociedadgastronomica.R;
import sociedadgastronomica.databinding.ActivityProductosBinding;

public class ProductosActivity extends AppCompatActivity {
    TravelPointsApplication tpa;
    ArrayAdapter<Producto> todoItemsAdapter;
    private ListView listView;
    private ActivityProductosBinding binding;
    private static final int SHOW_ADDACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tpa = (TravelPointsApplication) getApplicationContext();
        listView = (ListView) findViewById(R.id.listview);
        todoItemsAdapter = new ArrayAdapter<Producto>(this, R.layout.row_layout, R.id.listText, tpa.productos);

        listView.setAdapter(todoItemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("posicion", position);
                Intent intent = new Intent(getApplicationContext(), NuevoProductoActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, SHOW_ADDACTIVITY);
            }
        });
    }

    public void goBack(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
    public void anadirProducto(View view){
        Bundle bundle = new Bundle();
        bundle.putInt("posicion", -1);
        Intent intent = new Intent(getApplicationContext(), NuevoProductoActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, SHOW_ADDACTIVITY);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}