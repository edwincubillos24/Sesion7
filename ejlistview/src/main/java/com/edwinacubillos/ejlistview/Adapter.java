package com.edwinacubillos.ejlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Edwin on 03/10/2015.
 */

public class Adapter extends ArrayAdapter<Lista_Entrada> {

    private Lista_Entrada[] datos =
            new Lista_Entrada[] {
                    new Lista_Entrada(R.drawable.supermanlogo, "Superman", "Clak Kent", "1938"),
                    new Lista_Entrada(R.drawable.flashlogo, "Flash", "Barry Allen","1940"),
                    new Lista_Entrada(R.drawable.mujermaravillalogo, "Mujer Maravilla", "Diana", "1941"),
                    new Lista_Entrada(R.drawable.acuamanlogo,"Acuaman","Arthur Curry", "1941")};

    public Adapter(Context context, Lista_Entrada[] datos) {
        super(context, R.layout.layout_item, datos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_item, null);

        TextView nombre = (TextView) item.findViewById(R.id.tNombre);
        nombre.setText(datos[position].getNombre());

        TextView nombrePila = (TextView) item.findViewById(R.id.tNombrePila);
        nombre.setText(datos[position].getNombrePila());

        TextView fecha = (TextView) item.findViewById(R.id.fecha);
        nombre.setText(datos[position].getFecha());

        ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
        imagen.setImageResource(datos[position].getIdImagen());

        return item;
    }
}
