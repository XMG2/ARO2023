package com.example.testListMaterialMenuFloatButton;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    int position;
    ElementosDeViajeApp eva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        eva = (ElementosDeViajeApp)getApplicationContext();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        position = bundle.getInt("position");
        /*TextView textView = ((TextView) findViewById(R.id.textViewTitle2));
        textView.setTextSize(20);
        textView.setText(eva.elementoList.get(position).toString());
        TextView textView2 =((TextView) findViewById(R.id.textViewName));
        textView2.setTextSize(20);
        textView2.setText(eva.elementoList.get(position).toString());*/
    }

    public void goBack(View view){
        finish();
    }

}