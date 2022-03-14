package com.example.testListMaterialMenuFloatButton;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;

public class AddNameActivity extends AppCompatActivity {

    ElementosDeViajeApp eva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        eva = (ElementosDeViajeApp)getApplicationContext();
        TextView textView1 =((TextView) findViewById(R.id.edit_text));
        textView1.setTextSize(40);
        textView1.setText("nombre");

        TextView textView2 =((TextView) findViewById(R.id.editText2));
        textView2.setTextSize(40);
        textView2.setText("descripcion");

    }

    public void addName(View view){

        EditText editText = (EditText) findViewById(R.id.edit_text);
        String name = editText.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String latitud =editText2.getText().toString();

        Elemento elemento = new Elemento(name,latitud.toString(),10);
        //System.out.println(interestPoint.toString());
        eva.elementoList.add(elemento);
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}