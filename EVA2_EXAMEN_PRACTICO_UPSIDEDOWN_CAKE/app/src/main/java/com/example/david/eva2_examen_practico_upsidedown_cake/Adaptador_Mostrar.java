package com.example.david.eva2_examen_practico_upsidedown_cake;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador_Mostrar extends ArrayAdapter {
    Context cContexto;
    int iLayout;
    ArrayList aRestaurantes;

    public Adaptador_Mostrar(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        cContexto = context;
        iLayout = resource;
        aRestaurantes = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //LinearLayout lytFondoitem;
        TextView txtNom, txtDes, txtDir;
        ImageView imvImagen, lblRaiting1, lblRaiting2, lblRaiting3;

        View fila = convertView;
        if (fila == null) {
            LayoutInflater liVista = ((Activity) cContexto).getLayoutInflater();
            fila = liVista.inflate(iLayout, parent, false);
        }
        txtNom = fila.findViewById(R.id.lblNombreE);
        txtDes = fila.findViewById(R.id.lblDescripcionE);
        txtDir = fila.findViewById(R.id.lblDireccionTel);
        imvImagen = fila.findViewById(R.id.imvImagen);
        lblRaiting1 = fila.findViewById(R.id.lblRaiting1);
        lblRaiting2 = fila.findViewById(R.id.lblRaiting2);
        lblRaiting3 = fila.findViewById(R.id.lblRaiting3);
        //lytFondoitem = fila.findViewById(R.id.lytFondoitem);


        Capturar.Restaurante restauranteVal = Capturar.ArrayList.get(position);
        txtNom.setText(restauranteVal.sNombreResta);
        txtDes.setText(restauranteVal.sDescripcion);
        txtDir.setText(restauranteVal.sDireccion + "  tel:" + restauranteVal.sTelefono);
        imvImagen.setImageResource(restauranteVal.iImagen);
        try {
            Evaluacion.GuardarEstrella estrellitas;
            for (int i = 0; i <= Evaluacion.ArrayList.size(); i++) {
                estrellitas = Evaluacion.ArrayList.get(i);
                if (estrellitas.iPos == position) {
                  //  Evaluacion.GuardarEstrella estrellitas = Evaluacion.ArrayList.get(position);
                    if (estrellitas.iCantEstrellas == 1) {
                        lblRaiting1.setImageResource(R.drawable.estrellallena);
                    } else if (estrellitas.iCantEstrellas == 2) {
                        lblRaiting1.setImageResource(R.drawable.estrellallena);
                        lblRaiting2.setImageResource(R.drawable.estrellallena);

                    } else if (estrellitas.iCantEstrellas == 3) {
                        lblRaiting1.setImageResource(R.drawable.estrellallena);
                        lblRaiting2.setImageResource(R.drawable.estrellallena);
                        lblRaiting3.setImageResource(R.drawable.estrellallena);
                    } else {
                        lblRaiting1.setImageResource(R.drawable.estrellavacia);
                        lblRaiting2.setImageResource(R.drawable.estrellavacia);
                        lblRaiting3.setImageResource(R.drawable.estrellavacia);
                    }
                }
            }
        } catch (Exception e) {
        }

        //lytFondoitem.setBackgroundResource(lReal.iFoto);

        return fila;
    }
}
