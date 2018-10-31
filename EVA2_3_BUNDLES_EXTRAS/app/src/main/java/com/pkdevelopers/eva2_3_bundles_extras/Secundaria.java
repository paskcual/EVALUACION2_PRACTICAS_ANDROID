package com.pkdevelopers.eva2_3_bundles_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Secundaria extends AppCompatActivity {

    TextView txtMensaje;
    Intent inLeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        txtMensaje = findViewById(R.id.txtMensaje);
        //RECUPERAR INTENTO QUE GENERO A SECUNDARIA
        inLeer = getIntent();
        //LEER LOS DATOS ENVIADOS
        txtMensaje.setText(inLeer.getStringExtra("MENSAJE"));
    }

    public void cerrarSecun(View v){
        finish();
    }
}
