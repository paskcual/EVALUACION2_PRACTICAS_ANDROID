package com.pkdevelopers.eva2_5_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//request code es un numero entero arbitrario, para identificar las actividades
//result code es la respuesta, puede ser ok, cancel u otras

public class MainActivity extends AppCompatActivity {

    TextView txtDatos;
    Intent inLanzarSecun;
    final int DATOS_SECUNDARIA = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDatos = findViewById(R.id.txtDatos);

        inLanzarSecun = new Intent(this, Secundaria.class);

    }

    public void click(View view){
        startActivityForResult(inLanzarSecun, DATOS_SECUNDARIA);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == DATOS_SECUNDARIA){//identificamos la actividad que nos manda el resultado
            if(resultCode == Activity.RESULT_OK){//identificamos la respuesta del usuario
                //aqui ejecutamos alguna accion
                String sCade = data.getStringExtra("DATOS");
                txtDatos.setText(sCade);
            }

        }

    }

}
