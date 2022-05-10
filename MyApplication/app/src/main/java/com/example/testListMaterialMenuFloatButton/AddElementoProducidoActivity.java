package com.example.testListMaterialMenuFloatButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.ElementoProducido;
import com.parse.ParseException;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;

public class AddElementoProducidoActivity extends AppCompatActivity {
    ArrayList<String> nombreRueda = new ArrayList<>(Arrays.asList("GMP WONDER", "DU MANS", "SPEEDLINE", "OZ SUPERTURISMO", "MAK NURBUG", "STUTTGART", "RONAL", "OZ ULTRALEGGERA", "TSW NURBURGRING"));
    ArrayList<String> nombreColor = new ArrayList<>(Arrays.asList("Blanco", "Amarillo", "Azul", "AzulOscuro", "Morado", "Naranja", "Rosa", "Turquesa", "Verde"));
    ElementosDeViajeApp eva;
    Spinner spinner,spinner2,spinner3;
    String tipoElemento,llanta,color;
    double precio;
    int cantidad;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_elemento_producido);

        eva = (ElementosDeViajeApp)getApplicationContext();
        spinner = (Spinner) findViewById(R.id.spinner3);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipoElementoProducido, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                System.out.println((int)spinner.getSelectedItemId());
                switch ((int)spinner.getSelectedItemId()) {
                    case 0:
                        spinner2.setVisibility(View.GONE);
                        spinner3.setVisibility(View.GONE);
                    case 1:
                        tipoElemento = "Llanta";
                        spinner2.setVisibility(View.GONE);
                        spinner3.setVisibility(View.VISIBLE);
                        color=null;
                        break;
                    case 2:
                        tipoElemento = "Color";
                        spinner2.setVisibility(View.VISIBLE);
                        spinner3.setVisibility(View.GONE);
                        llanta=null;
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2 = (Spinner) findViewById(R.id.spinner4);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.tipoColor, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                switch ((int)spinner2.getSelectedItemId()) {
                    case 0:
                        color = "Blanco";
                        break;
                    case 1:
                        color = "Amarillo";
                        break;
                    case 2:
                        color = "Azul";
                        break;
                    case 3:
                        color = "AzulOscuro";
                        break;
                    case 4:
                        color = "Morado";
                        break;
                    case 5:
                        color = "Naranja";
                        break;
                    case 6:
                        color = "Rosa";
                        break;
                    case 7:
                        color = "Turquesa";
                        break;
                    case 8:
                        color = "Verde";
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner3 = (Spinner) findViewById(R.id.spinner5);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.tipoLlanta, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                switch ((int)spinner3.getSelectedItemId()) {
                    case 0:
                        llanta = "GMP WONDER";
                        break;
                    case 1:
                        llanta = "DU MANS";
                        break;
                    case 2:
                        llanta = "SPEEDLINE";
                        break;
                    case 3:
                        llanta = "OZ SUPERTURISMO";
                        break;
                    case 4:
                        llanta = "MAK NURBUG";
                        break;
                    case 5:
                        llanta = "STUTTGART";
                        break;
                    case 6:
                        llanta = "RONAL";
                        break;
                    case 7:
                        llanta = "OZ ULTRALEGGERA";
                        break;
                    case 8:
                        llanta = "TSW NURBURGRING";
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
        EditText editText = (EditText) findViewById(R.id.editTextNumber3);
        cantidad =  Integer.parseInt(editText.getText().toString()) +1;
        editText.setText(""+cantidad);
    }

    public void restar(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextNumber3);
        cantidad =  Integer.parseInt(editText.getText().toString());
        if(cantidad>1) {
            cantidad--;
            editText.setText(""+cantidad);
        }
    }

    public void addHerramienta(View view) {
        int[] precioscolor = {100, 200, 200, 500, 300, 400, 600, 100, 200};
        int[] preciosrueda = {500, 2000, 1000, 2000, 6000, 4000, 6000, 1000, 2000};
        Elemento el;
        if(llanta!=null || color!=null) {
            EditText editText, editText2, editText3;
            double precio;
            String descripcion;
            String[] idElemento = new String[1];
            ElementoProducido elementoProducido;
            editText = (EditText) findViewById(R.id.editTextNumber3);
            cantidad =  Integer.parseInt(editText.getText().toString()) +1;
            editText2 = (EditText) findViewById(R.id.editTextTextMultiLine3);
            descripcion = editText2.getText().toString();

            if(tipoElemento=="Color"){
                precio=precioscolor[nombreColor.indexOf(color)];
                elementoProducido = new ElementoProducido(color, descripcion, cantidad, tipoElemento, precio);
                el=new Elemento(color, descripcion, cantidad, "ELEMENTOPRODUCIDO", idElemento[0]);
                eva.elementoList.add(el);
            } else {
                precio=preciosrueda[nombreRueda.indexOf(llanta)];
                elementoProducido = new ElementoProducido(llanta, descripcion, cantidad, tipoElemento, precio);
                el=new Elemento(llanta, descripcion, cantidad, "ELEMENTOPRODUCIDO", idElemento[0]);
                eva.elementoList.add(el);
            }
            Intent intent = new Intent();
            elementoProducido.saveEventually(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Log.v("Object saved in server" + elementoProducido.getObjectId(), "newParseObject()");
                        idElemento[0] = elementoProducido.getObjectId();
                        eva.elementoList.get(eva.elementoList.indexOf(el)).setIdElemento(idElemento[0]);
                    } else {
                        Log.v("failed saved to server" + e.getMessage(), "newParseObject()");
                    }

                }
            });
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}