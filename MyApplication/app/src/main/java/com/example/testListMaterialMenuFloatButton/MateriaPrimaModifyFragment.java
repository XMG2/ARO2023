package com.example.testListMaterialMenuFloatButton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testListMaterialMenuFloatButton.Modelos.Elemento;
import com.example.testListMaterialMenuFloatButton.Modelos.Herramienta;
import com.example.testListMaterialMenuFloatButton.Modelos.MateriaPrima;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MateriaPrimaModifyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MateriaPrimaModifyFragment extends Fragment {

    private String nombre,descripcion;
    private int cantidad,position;
    private List<Elemento> list;
    public MateriaPrimaModifyFragment() {
        // Required empty public constructor
    }
    public MateriaPrimaModifyFragment(MateriaPrima materiaPrima, List<Elemento> list, int position){
        nombre = materiaPrima.getNombre();
        descripcion = materiaPrima.getDescripcion();
        cantidad = materiaPrima.getCantidad();
        this.position = position;
        this.list=list;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MateriaPrimaModifyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MateriaPrimaModifyFragment newInstance(String param1, String param2) {
        MateriaPrimaModifyFragment fragment = new MateriaPrimaModifyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_materia_prima_modify, container, false);
    }
}