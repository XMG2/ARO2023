package com.example.testListMaterialMenuFloatButton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.ElementoAdapter;
import com.example.testListMaterialMenuFloatButton.Modelos.ElementoProducido;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;
import com.example.testListMaterialMenuFloatButton.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListView listView;
    public ArrayAdapter<String> adapter;
    private static final int SHOW_SUBACTIVITY = 1;
    private static final int SHOW_ADDACTIVITY = 2;
    ElementosDeViajeApp eva;
    ElementoAdapter todoItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = binding.toolbar;
        Context context = this;

        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listview);
        eva = (ElementosDeViajeApp)getApplicationContext();
        todoItemsAdapter = new ElementoAdapter(context, eva.elementoList);

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        SeleccionarTipoActivity.class);
                startActivityForResult(intent, SHOW_ADDACTIVITY);
            }
        });
        ParseQuery<Herramienta> query = ParseQuery.getQuery("Herramienta");
        query.findInBackground(new FindCallback<Herramienta>() {
            public void done(List<Herramienta> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                    for(int i = 0; i< scoreList.size();i++){

                        eva.elementoList.add(new Elemento(scoreList.get(i).getNombre(),scoreList.get(i).getDescripcion(),scoreList.get(i).getCantidad(),"HERRAMIENTA",scoreList.get(i).getObjectId()));
                        todoItemsAdapter.notifyDataSetChanged();

                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        ParseQuery<MateriaPrima> query2 = ParseQuery.getQuery("MateriaPrima");
        query2.findInBackground(new FindCallback<MateriaPrima>() {
            public void done(List<MateriaPrima> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                    for(int i = 0; i< scoreList.size();i++){

                        eva.elementoList.add(new Elemento(scoreList.get(i).getNombre(),scoreList.get(i).getDescripcion(),scoreList.get(i).getCantidad(),"MATERIAPRIMA",scoreList.get(i).getObjectId()));
                        todoItemsAdapter.notifyDataSetChanged();

                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        ParseQuery<ElementoProducido> query3 = ParseQuery.getQuery("ElementoProducido");
        query3.findInBackground(new FindCallback<ElementoProducido>() {
            public void done(List<ElementoProducido> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                    for(int i = 0; i< scoreList.size();i++){
                        eva.elementoList.add(new Elemento(scoreList.get(i).getNombre(),scoreList.get(i).getDescripcion(),scoreList.get(i).getCantidad(),"ELEMENTOPRODUCIDO",scoreList.get(i).getObjectId()));
                        todoItemsAdapter.notifyDataSetChanged();
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        listView.setAdapter(todoItemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                Elemento elemento = eva.elementoList.get(position);
                bundle.putString("idElemento",elemento.getIdElemento());
                bundle.putString("tipo",elemento.getTipo(1));
                bundle.putInt("position",position);
                Intent intent;
                switch (elemento.getTipo(1)){
                    case "HERRAMIENTA":
                        intent = new Intent(getApplicationContext(), DisplayActivity.class);

                        break;
                    case "ELEMENTOPRODUCIDO":
                        intent = new Intent(getApplicationContext(), DisplayActivity.class);

                        break;
                    case "MATERIAPRIMA":
                        intent = new Intent(getApplicationContext(), DisplayActivity.class);

                        break;
                    default:
                        intent = new Intent(getApplicationContext(), DisplayActivity.class);
                        intent.putExtras(bundle);
                        startActivityForResult(intent, SHOW_SUBACTIVITY);
                }
                intent.putExtras(bundle);
                startActivityForResult(intent, SHOW_SUBACTIVITY);

            }
        });
    }
//      /\
//     /  \
//   (| O  |)
//    |    |
//    |    |
//    L____|
//    ^^^^^^
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up materiaPrima, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {

            case R.id.herramienta: {
                Intent intent = new Intent(getApplicationContext(), AddHerramientaActivity.class);
                startActivityForResult(intent, SHOW_ADDACTIVITY);
                break;
            }
            case R.id.materiaPrima: {
                Intent intent = new Intent(getApplicationContext(), AddMateriaPrimaActivity.class);
                startActivityForResult(intent, SHOW_ADDACTIVITY);
                break;
            }
            case R.id.elementoProducido:{
                Intent intent = new Intent(getApplicationContext(), AddElementoProducidoActivity.class);
                startActivityForResult(intent, SHOW_ADDACTIVITY);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            todoItemsAdapter.notifyDataSetChanged();
        }
    }


}