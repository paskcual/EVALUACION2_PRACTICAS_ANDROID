package com.pkdevelopers.eva2_8_listas_personalizadas;

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

public class WeatherAdapter extends ArrayAdapter<Clima> {

    //guardamos los parametros como atributos de la clase
    Context cContexto;
    int iLayout;
    Clima[] aCiudadesClima;

    public WeatherAdapter(@NonNull Context context, int resource, @NonNull Clima[] objects) {
        super(context, resource, objects);

        cContexto = context;
        iLayout = resource;
        aCiudadesClima = objects;

    }

    //metodo que necesitamos para dibujar nuestro layout
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ImageView imgvwClima;
        TextView txtCiduad, txtTemperatura, txtDescripcion;

        //si no ha sido creado, crearlo y si no recuperarlo
        View vFila = convertView;

        if(vFila == null){//si es nulo no existe nuestra fila, hay que crearla
            //para crear nuestra vista usamos layoutinflater
            LayoutInflater liVista = ((Activity) cContexto).getLayoutInflater();//los rcuros vienen de la actividad y la actividad la obtuvimos del contexto
            vFila = liVista.inflate(iLayout, parent, false);

        }
        //vinculamos los widgets despues de crearla, vamos a tomar los recursos de la vista fila
        imgvwClima = vFila.findViewById(R.id.ivClima);
        txtCiduad = vFila.findViewById(R.id.txtCiudad);
        txtTemperatura = vFila.findViewById(R.id.txtTemperatura);
        txtDescripcion = vFila.findViewById(R.id.txtDescripcion);

        //llenar los datos
        Clima cActual = aCiudadesClima[position];
        imgvwClima.setImageResource(cActual.imagen);
        txtCiduad.setText(cActual.nombreCiudad);
        txtTemperatura.setText(cActual.temperatura + "");
        txtDescripcion.setText(cActual.descripcion);

        return vFila;

    }
}
