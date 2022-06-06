package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;


public class HerramientaModifyFragment extends Fragment {

    private int position;
    // TODO: Rename and change types of parameters
    private String nombre,descripcion;
    private int cantidad=1;
    protected Herramienta herramienta;
    TextView textView1,textView2,textView4;
    protected List<Elemento> elementos;

    public HerramientaModifyFragment() {
        // Required empty public constructor
    }
    public HerramientaModifyFragment(Herramienta herramienta,List<Elemento> elementos,int position){
        this.herramienta=herramienta;
        this.elementos= elementos;
        this.position=position;
        nombre = herramienta.getNombre();
        descripcion = herramienta.getDescripcion();
        cantidad = herramienta.getCantidad();
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
                descripcion = textView2.getText().toString();
                nombre = textView1.getText().toString();
                cantidad = Integer.parseInt(textView4.getText().toString());
                herramienta.setNombre(nombre);
                herramienta.setDescripcion(descripcion);
                herramienta.setCantidad(cantidad);
                elementos.get(position).setDescripcion(descripcion);
                elementos.get(position).setCantidad(cantidad);
                elementos.get(position).setNombre(nombre);
                herramienta.saveEventually(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.v("Object saved in server"+herramienta.getObjectId(),"newParseObject()");
                        } else {
                            Log.v("failed saved to server"+ e.getMessage(),"newParseObject()");
                        }

                    }
                });
                getActivity().onBackPressed();

            }
        });
        return view;
    }
}