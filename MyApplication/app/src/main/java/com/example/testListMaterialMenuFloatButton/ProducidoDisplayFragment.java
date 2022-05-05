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

import java.util.List;


public class ProducidoDisplayFragment extends Fragment {

    protected ElementoProducido producido;
    private String nombre,descripcion,compuesto;
    private int cantidad, position;
    Double precio;
    List<Elemento> elementos;
    public ProducidoDisplayFragment() {
        // Required empty public constructor
    }
    public ProducidoDisplayFragment(ElementoProducido producido, List<Elemento> elementos, int position){
        this.producido=producido;
        this.elementos=elementos;
        this.position=position;
        precio = producido.getPrecio();
        nombre = producido.getNombre();
        descripcion = producido.getDescripcion();
        compuesto = producido.getCompuesto();
        cantidad = producido.getCantidad();
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
        textView3.setText("Precio: "+precio);
        textView4.setText("Cantidad: " + cantidad);
        textView5.setText(compuesto);
        return view;
    }
}