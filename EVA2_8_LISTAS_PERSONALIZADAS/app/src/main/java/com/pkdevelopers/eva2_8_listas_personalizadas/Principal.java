package com.pkdevelopers.eva2_8_listas_personalizadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener {

    Intent inDetalle;

    Clima[] cCiudad = {
            new Clima("CHIHUAHUA",10,"Nublado",R.drawable.cloudy),
            new Clima("DELICIAS",10,"Lluvioso",R.drawable.rainy),
            new Clima("CAMARGO",10,"Soleado",R.drawable.cloudy),
            new Clima("JUAREZ",10,"Nublado",R.drawable.cloudy),
            new Clima("CHIAPAS",10,"Lluvioso",R.drawable.sunny),
            new Clima("PUEBLA",10,"Soleado",R.drawable.cloudy),
            new Clima("JIMENEZ",10,"Nublado",R.drawable.cloudy),
            new Clima("OJINAGA",10,"Lluvioso",R.drawable.cloudy),
            new Clima("CUAHUTEMOC",10,"Soleado",R.drawable.rainy),
            new Clima("CREEL",10,"Nublado",R.drawable.cloudy),
            new Clima("WARRIOR CITY",10,"Lluvioso",R.drawable.sunny),
            new Clima("REYNO CHAMPIÑON",10,"Soleado",R.drawable.cloudy),
            new Clima("UMBRELLA",10,"Nublado",R.drawable.cloudy),
            new Clima("ALDAMA",10,"Lluvioso",R.drawable.cloudy),
            new Clima("CHIHUAHUA CHILE CHILACA",10,"Soleado",R.drawable.cloudy)
    };

    ListView lstvwPrimera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lstvwPrimera = findViewById(R.id.lstvwPrimera);

        //asignamos el adaptador
        lstvwPrimera.setAdapter(new WeatherAdapter(this, R.layout.layout_clima, cCiudad));

        lstvwPrimera.setOnItemClickListener(this);
        inDetalle = new Intent(this,ClimaDetalle.class);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        inDetalle.putExtra("IMAGEN", cCiudad[position].imagen);
        inDetalle.putExtra("CIUDAD",cCiudad[position].nombreCiudad);
        inDetalle.putExtra("TEMP",cCiudad[position].temperatura);
        inDetalle.putExtra("DESC", cCiudad[position].descripcion);

        startActivity(inDetalle);

    }
}
