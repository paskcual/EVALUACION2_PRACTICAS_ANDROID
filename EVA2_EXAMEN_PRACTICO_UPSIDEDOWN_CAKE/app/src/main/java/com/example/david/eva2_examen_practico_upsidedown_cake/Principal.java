package com.example.david.eva2_examen_practico_upsidedown_cake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    //COMPONENTES
    ImageView imgRamsey;
    Button btnCapturar, btnMostrar, btnSalir;

    //INTENTOS
    Intent inCapturar, inMostrar, inSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //INSTANCIAR LOS COMPONENTES
        imgRamsey = findViewById(R.id.imgRamsey);

        //IMAGEN DE PANTALLA PRINCIPAL
        imgRamsey.setImageResource(R.drawable.ramsey);

        //INTENTOS
        inCapturar = new Intent(this, Capturar.class);

        inMostrar = new Intent(this,Mostrar.class);
    }

    //METODO DEL BOTON CAPTURAR
    public void Clickcapturar(View v){
        //LANZA LA ACTIVIDAD CAPTURAR
        startActivity(inCapturar);
    }

    //METODO DEL BOTON MOSTRAR
    public void Clickmostrar(View v){
        startActivity(inMostrar);
    }

    //METODO DEL BOTON SALIR
    public void Clicksalir(View v){
        finish();
    }
}
