package com.example.david.eva2_examen_practico_upsidedown_cake;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class Adaptador extends ArrayAdapter {
    Context cContexto;
    int iLayout;
    Listafotos[] lListafotos;

    public Adaptador(@NonNull Context context, int resource, @NonNull Listafotos[] objects) {
        super(context, resource, objects);
        cContexto = context;
        iLayout = resource;
        lListafotos = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout lytFondoitem;
        View fila = convertView;
        if (fila == null) {
            LayoutInflater liVista = ((Activity) cContexto).getLayoutInflater();
            fila = liVista.inflate(iLayout, parent, false);
        }

        lytFondoitem = fila.findViewById(R.id.lytFondoitem);

        Listafotos lReal = lListafotos[position];
        lytFondoitem.setBackgroundResource(lReal.iFoto);

        return fila;
    }
}
