package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;


public class MateriaPrimaDisplayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String nombre,descripcion,volumen,compuesto;
    private int cantidad;
    public MateriaPrimaDisplayFragment() {
        // Required empty public constructor
    }
    public MateriaPrimaDisplayFragment(MateriaPrima materia){
        nombre = materia.getNombre();
        descripcion = materia.getDescripcion();
        compuesto = materia.getCompuesto();
        volumen = ""+materia.getVolumen();
        cantidad = materia.getCantidad();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materia_prima_display,container,false);
        TextView textView1 = (TextView)view.findViewById(R.id.nombreMateria2);
        TextView textView2 = (TextView)view.findViewById(R.id.descripcionMateria);
        TextView textView3 = (TextView)view.findViewById(R.id.volumen);
        TextView textView4 = (TextView)view.findViewById(R.id.cantidadMateria);
        TextView textView5 = (TextView)view.findViewById(R.id.compuesto);
        textView1.setText(nombre);
        textView2.setText(descripcion);
        textView3.setText("Volumen: "+volumen);
        textView4.setText("Cantidad: " + cantidad);
        textView5.setText(compuesto);
        return view;
    }
}