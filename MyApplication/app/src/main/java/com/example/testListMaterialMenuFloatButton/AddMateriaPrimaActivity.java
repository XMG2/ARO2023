package com.example.testListMaterialMenuFloatButton;

import static androidx.transition.Visibility.MODE_OUT;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;
import com.parse.ParseException;
import com.parse.SaveCallback;


public class AddMateriaPrimaActivity extends AppCompatActivity {
    ElementosDeViajeApp eva;
    TextView alto,ancho,largo,diametro;
    RadioGroup radioGroup;
    String compuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia_prima);
        eva = (ElementosDeViajeApp)getApplicationContext();
        alto = (TextView) findViewById(R.id.editTextTextPersonName2);
        ancho = (TextView) findViewById(R.id.editTextTextPersonName3);
        largo = (TextView) findViewById(R.id.editTextTextPersonName4);
        diametro = (TextView) findViewById(R.id.editTextTextPersonName5);
        alto.setVisibility(View.INVISIBLE);
        ancho.setVisibility(View.INVISIBLE);
        largo.setVisibility(View.INVISIBLE);
        diametro.setVisibility(View.INVISIBLE);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton cilindro = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rectangulo = (RadioButton) findViewById(R.id.radioButton5);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton3){
                    // one of the radio buttons is checked
                    //System.out.println("circular");
                    alto.setVisibility(View.INVISIBLE);
                    ancho.setVisibility(View.INVISIBLE);
                    largo.setVisibility(View.VISIBLE);
                    diametro.setVisibility(View.VISIBLE);
                }else if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton5){
                    // one of the radio buttons is checked
                    //System.out.println("rectangular");
                    alto.setVisibility(View.VISIBLE);
                    ancho.setVisibility(View.VISIBLE);
                    largo.setVisibility(View.VISIBLE);
                    diametro.setVisibility(View.INVISIBLE);
                }

            }

        };
        cilindro.setOnClickListener(listener);
        rectangulo.setOnClickListener(listener);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.composicionMateria, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                //System.out.println(spinner.getSelectedItemId());
                switch ((int)spinner.getSelectedItemId()) {
                    case 1:
                        compuesto = "ALUMINIO";
                        break;
                    case 2:
                        compuesto = "ACERO";
                        break;
                    case 3:
                        compuesto = "TITANIO";
                        break;
                    case 4:
                        compuesto = "CARBONO";
                        break;
                    case 5:
                        compuesto = "NETHERITE";
                        break;
                    case 6:
                        compuesto = "NUKA_COLA";
                        break;
                    case 7:
                        compuesto = "VIBRANIUM";
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void addMateriaPrima(View view) {
        String nombre,descripcion;
        final String[] idElemento = new String[1];
        Double diametro,largo,alto,ancho;
        int cantidad;
        MateriaPrima materia;
        Elemento el;
        EditText editText,editText2,editText3,editText4,editText5,editText6,editText7;
        switch (radioGroup.getCheckedRadioButtonId()){
            case(R.id.radioButton3):
                editText6 = (EditText) findViewById(R.id.editTextTextPersonName6);
                nombre =  editText6.getText().toString();
                editText2 = (EditText) findViewById(R.id.editTextTextMultiLine);
                descripcion =editText2.getText().toString();
                editText3 = (EditText) findViewById(R.id.editTextTextPersonName5);
                diametro = Double.parseDouble(editText3.getText().toString());
                editText4 = (EditText) findViewById(R.id.editTextTextPersonName4);
                largo =Double.parseDouble(editText4.getText().toString());
                editText5 = (EditText) findViewById(R.id.editTextNumber);
                cantidad =  Integer.parseInt(editText5.getText().toString());
                materia = new MateriaPrima(nombre,descripcion,compuesto,diametro,largo,cantidad);
                el=new Elemento(nombre,descripcion,cantidad, "MATERIAPRIMA",idElemento[0]);
                eva.elementoList.add(el);
                materia.saveEventually(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.v("Object saved in server"+materia.getObjectId(),"newParseObject()");
                            idElemento[0] = materia.getObjectId();
                            System.out.println("\n\nHe guardado\n\n"+idElemento[0]+"\n\n");
                            eva.elementoList.get(eva.elementoList.indexOf(el)).setIdElemento(idElemento[0]);
                        } else {
                            System.out.println("#############################");
                            Log.v("failed saved to server"+ e.getMessage(),"newParseObject()");
                        }

                    }
                });


                break;
            case(R.id.radioButton5):
                editText6 = (EditText) findViewById(R.id.editTextTextPersonName6);
                nombre =  editText6.getText().toString();
                editText2 = (EditText) findViewById(R.id.editTextTextMultiLine);
                descripcion =editText2.getText().toString();
                editText3 = (EditText) findViewById(R.id.editTextTextPersonName2);
                alto = Double.parseDouble(editText3.getText().toString());
                editText4 = (EditText) findViewById(R.id.editTextTextPersonName4);
                largo = Double.parseDouble(editText4.getText().toString());
                editText5 = (EditText) findViewById(R.id.editTextTextPersonName3);
                ancho = Double.parseDouble(editText5.getText().toString());
                editText7 = (EditText) findViewById(R.id.editTextNumber);
                cantidad =  Integer.parseInt(editText7.getText().toString());
                materia = new MateriaPrima(nombre,descripcion,compuesto,alto,ancho,largo,cantidad);
                materia.saveEventually(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.v("Object saved in server"+materia.getObjectId(),"newParseObject()");
                            idElemento[0] = materia.getObjectId();
                        } else {
                            Log.v("failed saved to server"+ e.getMessage(),"newParseObject()");
                        }

                    }
                });
                eva.elementoList.add(new Elemento(nombre,descripcion,cantidad, "MATERIAPRIMA",idElemento[0]));
                break;
        }
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
    public void volver(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    public void sumar(View view) {
        int cantidad;
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        cantidad =  Integer.parseInt(editText.getText().toString()) +1;
        editText.setText(""+cantidad);
    }

    public void restar(View view) {
        int cantidad;
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        cantidad =  Integer.parseInt(editText.getText().toString());
        if(cantidad>1) {
            cantidad--;
            editText.setText(""+cantidad);
        }
    }
}