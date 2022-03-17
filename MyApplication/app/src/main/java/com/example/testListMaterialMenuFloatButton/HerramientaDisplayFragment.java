package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;


public class HerramientaDisplayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private String nombre,descripcion,funcion;
    private int cantidad;
    public HerramientaDisplayFragment() {
        // Required empty public constructor
    }
    public HerramientaDisplayFragment(Herramienta herramienta){
        nombre = herramienta.getNombre();
        descripcion = herramienta.getDescripcion();
        funcion = ""+herramienta.getFuncion();
        cantidad = herramienta.getCantidad();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_herramienta_display,container,false);
        TextView textView1 = (TextView)view.findViewById(R.id.nombreHerramienta);
        TextView textView2 = (TextView)view.findViewById(R.id.descripcionHerramienta);
        TextView textView3 = (TextView)view.findViewById(R.id.funcionHerramienta);
        TextView textView4 = (TextView)view.findViewById(R.id.cantidadHerramienta);
        textView1.setText(nombre);
        textView2.setText(descripcion);
        textView3.setText(funcion);
        textView4.setText("Cantidad: " + cantidad);
        return view;
    }

}