package com.example.testListMaterialMenuFloatButton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SeleccionarTipoActivity extends AppCompatActivity {
    private static final int SHOW_ADDHERRAMIENTAACTIVITY = 2,SHOW_ADDPRIMAACTIVITY = 1,SHOW_ADDPRODUCIDOACTIVITY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_tipo);
    }

    public void anadirMateriaPrima(View view) {
        Intent intent = new Intent(getApplicationContext(),
                AddMateriaPrimaActivity.class);
        startActivityForResult(intent, SHOW_ADDPRIMAACTIVITY);
    }

    public void anadirHerramienta(View view) {
        Intent intent = new Intent(getApplicationContext(),
                AddHerramientaActivity.class);
        startActivityForResult(intent, SHOW_ADDHERRAMIENTAACTIVITY);
    }

    public void anadirElementoProducido(View view) {
        Intent intent = new Intent(getApplicationContext(),
                AddElementoProducidoActivity.class);
        startActivityForResult(intent, SHOW_ADDPRODUCIDOACTIVITY);
    }

    public void volver(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}