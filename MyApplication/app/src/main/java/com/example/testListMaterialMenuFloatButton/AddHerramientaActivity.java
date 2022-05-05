package com.example.testListMaterialMenuFloatButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.parse.ParseException;
import com.parse.SaveCallback;

public class AddHerramientaActivity extends AppCompatActivity {
    String funcion;
    ElementosDeViajeApp eva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_herramienta);
        eva = (ElementosDeViajeApp)getApplicationContext();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.funcionesHerramienta, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                System.out.println(spinner.getSelectedItemId());
                switch ((int)spinner.getSelectedItemId()) {
                    case 1:
                        funcion = "CORTE";
                        break;
                    case 2:
                        funcion = "SOLDADURA";
                        break;
                    case 3:
                        funcion = "ATORNILLAR";
                        break;
                    case 4:
                        funcion = "GOLPE";
                        break;
                    case 5:
                        funcion = "APRETAR";
                        break;
                    case 6:
                        funcion = "MEDIR";
                        break;
                    case 7:
                        funcion = "LIJA";
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    public void volver(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    public void sumar(View view) {
        int cantidad;
        EditText editText = (EditText) findViewById(R.id.editTextNumber2);
        cantidad =  Integer.parseInt(editText.getText().toString()) +1;
        editText.setText(""+cantidad);
    }

    public void restar(View view) {
        int cantidad;
        EditText editText = (EditText) findViewById(R.id.editTextNumber2);
        cantidad =  Integer.parseInt(editText.getText().toString());
        if(cantidad>1) {
            cantidad--;
            editText.setText(""+cantidad);
        }
    }

    public void addHerramienta(View view) {
        EditText editText,editText2,editText3;
        int cantidad;
        String nombre,descripcion;
        Herramienta herramienta;
        final String[] idElemento = new String[1];
        editText = (EditText) findViewById(R.id.editTextTextPersonName7);
        nombre = editText.getText().toString();
        editText2 = (EditText) findViewById(R.id.editTextTextMultiLine2);
        descripcion =editText2.getText().toString();
        editText3 = (EditText)findViewById(R.id.editTextNumber2);
        cantidad =  Integer.parseInt(editText3.getText().toString());
        herramienta = new Herramienta(nombre,descripcion,cantidad,funcion);
        Intent intent = new Intent();
        herramienta.saveEventually(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.v("Object saved in server"+herramienta.getObjectId(),"newParseObject()");
                    idElemento[0] = herramienta.getObjectId();
                } else {
                    Log.v("failed saved to server"+ e.getMessage(),"newParseObject()");
                }

            }
        });
        eva.elementoList.add(new Elemento(nombre,descripcion,cantidad, "HERRAMIENTA",idElemento[0]));
        setResult(RESULT_OK, intent);
        finish();

    }
}