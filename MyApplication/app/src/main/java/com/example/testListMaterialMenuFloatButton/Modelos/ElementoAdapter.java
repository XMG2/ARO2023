package com.example.testListMaterialMenuFloatButton.Modelos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testListMaterialMenuFloatButton.R;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ElementoAdapter extends ArrayAdapter<Elemento> {
    private Context mContext;
    private List<Elemento> elementoList = new ArrayList<>();
    public ElementoAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<Elemento> list){
        super(context,0,list);
        this.mContext = context;
        this.elementoList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.layout_elemento,parent,false);
        Elemento elemento = elementoList.get(position);
        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
        switch (elemento.tipo){
            case HERRAMIENTA:
                image.setImageResource(R.drawable.herramienta);
                break;
            case MATERIAPRIMA:
                image.setImageResource(R.drawable.materiaprima);
                break;
            case ELEMENTOPRODUCIDO:
                image.setImageResource(R.drawable.elementoproducido);
                break;
            default:
                image.setImageResource(R.drawable.ic_launcher_foreground);
                break;
        }
        TextView textView1 = (TextView) listItem.findViewById(R.id.textView_name);
        textView1.setText(elemento.getNombre());
        TextView textView2 = (TextView) listItem.findViewById(R.id.textView_descripcion);
        textView2.setText(elemento.getDescripcion());
        return listItem;
    }
}
