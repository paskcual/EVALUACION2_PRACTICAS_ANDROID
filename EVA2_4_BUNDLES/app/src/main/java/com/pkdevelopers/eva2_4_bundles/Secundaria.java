package com.pkdevelopers.eva2_4_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {

    TextView txtMostrar;
    Intent inDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        //VINCULAMOS
        txtMostrar = findViewById(R.id.txtMostrar);
        //OBTENEMOS INTENTO
        inDatos = getIntent();
        //ASIGNAMOS LOS EXTRAS AL BUNDLE
        Bundle bDatos = inDatos.getExtras();
        //MOSTRAMOS INFORMACION EN TXTMOSTRAR
        txtMostrar.append("Nombre: " + bDatos.getString("NOMBRE"));
        txtMostrar.append(" | Apellido: " + bDatos.getString("APELLIDO"));
        txtMostrar.append(" | Edad: " + bDatos.getInt("EDAD"));

        if(bDatos.getBoolean("LABORA")){
            txtMostrar.append(" | Trabaja: si, ");
            txtMostrar.append("Salario: $" + bDatos.getDouble("SALARIO"));

        }else{
            txtMostrar.append(" | Trabaja: no");
        }

        switch(bDatos.getInt("GENERO")){
            case 1:
                txtMostrar.append(" | Masculino");
                break;

            case 2:
                txtMostrar.append(" | Femenino");
                break;

            case 3:
                txtMostrar.append(" | Otro");
                break;

        }

    }

    public void cerrarSecun(View v){
        finish();
    }

}
