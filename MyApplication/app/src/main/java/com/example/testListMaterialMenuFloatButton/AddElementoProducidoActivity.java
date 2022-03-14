package com.example.testListMaterialMenuFloatButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.testListMaterialMenuFloatButton.Modelos.ElementoProducido;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;

import java.awt.font.NumericShaper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AddElementoProducidoActivity extends AppCompatActivity {
    private NumberPicker picker;
    List<Integer> numbers;
    List<String> numbers2;
    ElementosDeViajeApp eva;
    double precio;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_elemento_producido);

        eva = (ElementosDeViajeApp)getApplicationContext();

        numbers = Stream.iterate(0, n -> n + 1).limit(1001).collect(Collectors.toList());
        numbers2 = numbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList());
        String[] num = new String[numbers2.size()];
        numbers2.toArray(num);
        picker = (NumberPicker)findViewById(R.id.numberPicker);
        NumberPicker.OnValueChangeListener onValueChangeListener =
                new	NumberPicker.OnValueChangeListener(){
                    @Override
                    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                        precio = numberPicker.getValue()/100.0;

                    }
                };
        picker.setOnValueChangedListener(onValueChangeListener);
        picker.setMinValue(0);
        picker.setMaxValue(1000);
        picker.setDisplayedValues(num);
    }
    public void volver(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    public void sumar(View view) {
        int cantidad;
        EditText editText = (EditText) findViewById(R.id.editTextNumber3);
        cantidad =  Integer.parseInt(editText.getText().toString()) +1;
        editText.setText(""+cantidad);
    }

    public void restar(View view) {
        int cantidad;
        EditText editText = (EditText) findViewById(R.id.editTextNumber3);
        cantidad =  Integer.parseInt(editText.getText().toString());
        if(cantidad>1) {
            cantidad--;
            editText.setText(""+cantidad);
        }
    }

    public void addHerramienta(View view) {
        EditText editText,editText2,editText3,editText4;
        NumberPicker picker;
        int cantidad;
        double precio;
        String nombre,descripcion,compuesto;
        editText = (EditText) findViewById(R.id.editTextTextPersonName8);
        nombre = editText.getText().toString();
        editText2 = (EditText) findViewById(R.id.editTextTextMultiLine3);
        descripcion =editText2.getText().toString();
        editText4 = (EditText)findViewById(R.id.editTextTextPersonName9);
        compuesto = editText4.getText().toString();
        picker = (NumberPicker)findViewById(R.id.numberPicker);
        precio = picker.getValue()/100.0;
        editText3 = (EditText)findViewById(R.id.editTextNumber3);
        cantidad =  Integer.parseInt(editText3.getText().toString());
        eva.elementoList.add(new ElementoProducido(nombre,descripcion,cantidad,compuesto,precio));
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}