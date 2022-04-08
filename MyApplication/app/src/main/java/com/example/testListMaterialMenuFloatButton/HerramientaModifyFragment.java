package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;

import java.util.List;


public class HerramientaModifyFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private String nombre,descripcion;
    private int cantidad,position;
    private List<Elemento> list;
    TextView textView1,textView2,textView4;

    public HerramientaModifyFragment() {
        // Required empty public constructor
    }
    public HerramientaModifyFragment(Herramienta herramienta, List<Elemento> list, int position){
        nombre = herramienta.getNombre();
        descripcion = herramienta.getDescripcion();
        cantidad = herramienta.getCantidad();
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
        textView4 = (TextView)view.findViewById(R.id.editTextNumber4);
        textView1.setText(nombre);
        textView2.setText(descripcion);
        textView4.setText(""+cantidad);
        Button button = (Button) view.findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad =  Integer.parseInt(textView4.getText().toString()) +1;
                textView4.setText(""+cantidad);
            }
        });
        Button button1 = (Button) view.findViewById(R.id.button7);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad;
                cantidad =  Integer.parseInt(textView4.getText().toString());
                if(cantidad>1) {
                    cantidad--;
                    textView4.setText(""+cantidad);
                }
            }
        });
        Button button2 = (Button) view.findViewById(R.id.eliminar);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = textView1.getText().toString();
                descripcion = textView2.getText().toString();
                cantidad = Integer.parseInt(textView4.getText().toString());
                list.get(position).setCantidad(cantidad);
                list.get(position).setNombre(nombre);
                list.get(position).setDescripcion(descripcion);
                getActivity().onBackPressed();

            }
        });
        return view;
    }
}