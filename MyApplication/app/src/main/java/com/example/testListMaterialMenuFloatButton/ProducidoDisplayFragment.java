package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.ElementoProducido;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;


public class ProducidoDisplayFragment extends Fragment {


    private String nombre,descripcion,volumen,compuesto;
    private int cantidad;
    public ProducidoDisplayFragment() {
        // Required empty public constructor
    }
    public ProducidoDisplayFragment(String elementoId ){
        ParseQuery<ElementoProducido> query = ParseQuery.getQuery("ElementoProducido");
        query.getInBackground(elementoId, new GetCallback<ElementoProducido>() {
            public void done(ElementoProducido producido, ParseException e) {
                if (e == null) {
                    nombre = producido.getNombre();
                    descripcion = producido.getDescripcion();
                    cantidad = producido.getCantidad();
                    compuesto = producido.getCompuesto();

                } else {
                    // something went wrong
                }
            }
        });
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