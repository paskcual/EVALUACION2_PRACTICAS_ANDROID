package com.pkdevelopers.eva2_10_practica_restaurante;

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

public class AdaptadorRestaurante extends ArrayAdapter<Restaurante> {

    //guardamos los parametros como atributos de la clase
    Context cContexto;
    int iLayout;
    Restaurante[] aRestauranteContenido;


    public AdaptadorRestaurante(@NonNull Context context, int resource, @NonNull Restaurante[] objects) {
        super(context, resource, objects);

        cContexto = context;
        iLayout = resource;
        aRestauranteContenido = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ImageView imgvwRestaurante;
        TextView txtNombre, txtTipo;

        //si no ha sido creado, crearlo y si no recuperarlo
        View vFila = convertView;

        if(vFila == null){//si es nulo no existe nuestra fila, hay que crearla
            //para crear nuestra vista usamos layoutinflater
            LayoutInflater liVista = ((Activity) cContexto).getLayoutInflater();//los rcuros vienen de la actividad y la actividad la obtuvimos del contexto
            vFila = liVista.inflate(iLayout, parent, false);

        }
        //vinculamos los widgets despues de crearla, vamos a tomar los recursos de la vista fila
        imgvwRestaurante = vFila.findViewById(R.id.imgvwImagen);
        txtNombre = vFila.findViewById(R.id.txtNombreDetalle);
        txtTipo = vFila.findViewById(R.id.txtTipooo);

        //llenar los datos
        Restaurante cActual = aRestauranteContenido[position];
        imgvwRestaurante.setImageResource(cActual.imagen);
        txtNombre.setText(cActual.nombreRest);
        txtTipo.setText(cActual.tipoRest);

        return vFila;

    }
}
