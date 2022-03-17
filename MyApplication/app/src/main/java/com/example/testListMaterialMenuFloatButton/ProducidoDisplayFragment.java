package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.ElementoProducido;


public class ProducidoDisplayFragment extends Fragment {


    private String nombre,descripcion,volumen,compuesto;
    private int cantidad;
    public ProducidoDisplayFragment() {
        // Required empty public constructor
    }
    public ProducidoDisplayFragment(ElementoProducido materia){
        nombre = materia.getNombre();
        descripcion = materia.getDescripcion();
        compuesto = materia.getCompuesto();
        //volumen = ""+materia.getVolumen();
        cantidad = materia.getCantidad();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_producido_display,container,false);
        TextView textView1 = (TextView)view.findViewById(R.id.nombreProducido);
        TextView textView2 = (TextView)view.findViewById(R.id.descripcionProducido);
        TextView textView3 = (TextView)view.findViewById(R.id.precio);
        TextView textView4 = (TextView)view.findViewById(R.id.cantidadProducido);
        TextView textView5 = (TextView)view.findViewById(R.id.compuesto);
        textView1.setText(nombre);
        textView2.setText(descripcion);
        textView3.setText("Precio: "+volumen);
        textView4.setText("Cantidad: " + cantidad);
        textView5.setText(compuesto);
        return view;
    }
}