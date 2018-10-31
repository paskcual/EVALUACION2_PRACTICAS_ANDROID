package com.pkdevelopers.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    //INICIALIZAMOS TEXTVIEW
    TextView txtRestaurante, txtTotal;
    //INICIALIZAMOS INTENTOS
    Intent inResta, inOrden;
    //INICIALIZAMOS VARIABLES
    final int LISTA_RESTA = 100;
    final int ORDEN = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //VINCULAMOS
        txtRestaurante = findViewById(R.id.txtRestauante);
        txtTotal = findViewById(R.id.hjhj);

        //CREAMOS UN NUEVO INTENTO
        inResta = new Intent(this, Secundaria.class);
        inOrden = new Intent(this,Orden.class);

    }

    //METODO AL OPRIMIR BOTON DE SELECCIONAR RESTAUTANTE
    public void clickSeleccionRestaurante (View view){
        startActivityForResult(inResta, LISTA_RESTA);

    }

    public void calculaOrden(View view){
        startActivityForResult(inOrden, ORDEN);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LISTA_RESTA){

            if(resultCode == Activity.RESULT_OK){
                int iResta = data.getIntExtra("RESTAURANTE", 0);
                txtRestaurante.setText(Datos.sResta[iResta]);

            }
        }else if(requestCode == ORDEN){

            if(resultCode == Activity.RESULT_OK){
                double dTotal = data.getDoubleExtra("TOTAL",0);
                txtTotal.setText("$ " +dTotal);

            }

        }
    }
}
