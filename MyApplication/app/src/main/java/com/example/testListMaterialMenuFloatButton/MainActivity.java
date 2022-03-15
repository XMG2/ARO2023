package com.example.testListMaterialMenuFloatButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.testListMaterialMenuFloatButton.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //public List<String> nameList;
    private ListView listView;
    public ArrayAdapter<String> adapter;
    private static final int SHOW_SUBACTIVITY = 1;
    private static final int SHOW_ADDACTIVITY = 2;
    ElementosDeViajeApp eva;
    ElementoAdapter todoItemsAdapter;
    //ArrayAdapter<Elemento> todoItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = binding.toolbar;

        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listview);
        eva = (ElementosDeViajeApp)getApplicationContext();

        todoItemsAdapter = new ElementoAdapter(this, eva.elementoList);

        listView.setAdapter(todoItemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, SHOW_SUBACTIVITY);
            }
        });



        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        SeleccionarTipoActivity.class);
                startActivityForResult(intent, SHOW_ADDACTIVITY);
            }
        });
    }

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

            case R.id.action_reload: {
                eva.elementoList.clear();
                todoItemsAdapter.notifyDataSetChanged();
                break;
            }
            case R.id.action_new: {
                Intent intent = new Intent(getApplicationContext(), AddNameActivity.class);
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
            //System.out.println("uwu");
            todoItemsAdapter.notifyDataSetChanged();
            //System.out.println("Prueba de que llega aqui");
        }
    }

}