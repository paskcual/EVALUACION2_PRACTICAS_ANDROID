package com.pkdevelopers.eva2_8_listas_personalizadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ClimaDetalle extends AppCompatActivity {

    Intent inDatos;
    ImageView imgvwClima;
    TextView txtCiduad, txtTemperatura, txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima_detalle);

        imgvwClima = findViewById(R.id.imgvwClimaDet);
        txtCiduad = findViewById(R.id.txtCiudadDet);
        txtTemperatura = findViewById(R.id.txtTempDet);
        txtDescripcion = findViewById(R.id.txtDescripcionDet);
        inDatos = getIntent();

        imgvwClima.setImageResource(inDatos.getIntExtra("IMAGEN", R.drawable.cloudy));
        txtCiduad.setText(inDatos.getStringExtra("CIUDAD"));
        txtTemperatura.setText(inDatos.getIntExtra("TEMP", 0) + "°" );
        txtDescripcion.setText(inDatos.getStringExtra("DESC"));

    }
}
