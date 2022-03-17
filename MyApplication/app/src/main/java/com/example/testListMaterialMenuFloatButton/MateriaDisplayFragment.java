package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;


public class MateriaDisplayFragment extends Fragment {
    private String nombre,descripcion,volumen;
    private int cantidad;
    public MateriaDisplayFragment() {
        // Required empty public constructor
    }
    public MateriaDisplayFragment(MateriaPrima materiaPrima){
        nombre = materiaPrima.getNombre();
        descripcion = materiaPrima.getDescripcion();
        volumen = ""+materiaPrima.getVolumen();
        cantidad = materiaPrima.getCantidad();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materia_display,container,false);
        TextView textView1 = (TextView)view.findViewById(R.id.nombreMateria);
        TextView textView2 = (TextView)view.findViewById(R.id.descripcionMateria);
        TextView textView3 = (TextView)view.findViewById(R.id.volumen);
        TextView textView4 = (TextView)view.findViewById(R.id.cantidadMateria);
        textView1.setText(nombre);
        textView2.setText(descripcion);
        textView3.setText(volumen);
        textView4.setText(""+cantidad);
        return view;
    }
}