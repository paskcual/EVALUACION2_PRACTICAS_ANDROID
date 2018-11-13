package com.example.david.eva2_examen_practico_upsidedown_cake;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class Mostrar extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView lstRatings;
    Intent inEvaluacion;
    int iPos;
    int iEstrellas = 1;
    //ARREGLO DE LAS FOTOS DE LOS RESTAURANTES A SELECCIONAR


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        lstRatings = findViewById(R.id.lstRatings);
        lstRatings.setOnItemClickListener(this);
        //ADAPTADOR MOSTRAR
        lstRatings.setAdapter(new Adaptador_Mostrar(this, R.layout.listaratings, Capturar.ArrayList));
        inEvaluacion = new Intent(this, Evaluacion.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        iPos = position;
        inEvaluacion.putExtra("POS", iPos);
        //startActivity(inEvaluacion);
        finish();
        startActivity(inEvaluacion);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == iEstrellas) {
            if (resultCode == Activity.RESULT_OK) {
                int iResta = data.getIntExtra("ESTRELLAS", 0);
              //  lblTexto.setText(Datos.sRestaurantes[iResta]);
            }
        }
    }
}
