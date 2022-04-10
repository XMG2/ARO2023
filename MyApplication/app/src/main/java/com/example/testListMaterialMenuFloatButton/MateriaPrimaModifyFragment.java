package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;

import java.util.List;


public class MateriaPrimaModifyFragment extends Fragment {

    private String nombre,descripcion;
    private int cantidad,position;
    private List<Elemento> list;
    TextView textView1,textView2,textView3;

    public MateriaPrimaModifyFragment(MateriaPrima materiaPrima) {
        // Required empty public constructor
    }
    public MateriaPrimaModifyFragment(MateriaPrima materiaPrima, List<Elemento> list, int position){
        nombre = materiaPrima.getNombre();
        descripcion = materiaPrima.getDescripcion();
        cantidad = materiaPrima.getCantidad();
        this.position = position;
        this.list=list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_herramienta_modify,container,false);
        textView1 = (TextView)view.findViewById(R.id.editTextTextPersonName10);
        textView2 = (TextView)view.findViewById(R.id.editTextTextMultiLine4);
        textView3 = (TextView)view.findViewById(R.id.editTextNumber4);
        textView1.setText(nombre);
        textView2.setText(descripcion);
        textView3.setText(""+cantidad);
        Button button = (Button) view.findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad =  Integer.parseInt(textView3.getText().toString()) +1;
                textView3.setText(""+cantidad);
            }
        });
        Button button1 = (Button) view.findViewById(R.id.button7);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad;
                cantidad =  Integer.parseInt(textView3.getText().toString());
                if(cantidad>1) {
                    cantidad--;
                    textView3.setText(""+cantidad);
                }
            }
        });
        Button button2 = (Button) view.findViewById(R.id.eliminar);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = textView1.getText().toString();
                descripcion = textView2.getText().toString();
                cantidad = Integer.parseInt(textView3.getText().toString());
                list.get(position).setCantidad(cantidad);
                list.get(position).setNombre(nombre);
                list.get(position).setDescripcion(descripcion);
                getActivity().onBackPressed();

            }
        });
        return view;
    }
}