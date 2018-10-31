package com.pkdevelopers.eva2_5_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {

    //CREACION DE OBJETOS
    EditText etxtIntroduce;
    Intent inDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        //VINCULAMOS
        etxtIntroduce = findViewById(R.id.etxtIntroduceDato);

        //OBTENEMOS EL INTENTO QUE YA HICIMOS
        inDatos = getIntent();

    }

    public void clickSecun(View view){
        String sCade = etxtIntroduce.getText().toString();
        inDatos.putExtra("DATOS",sCade);//leemos esa cadena en el intento, con bundle o con exta
        setResult(Activity.RESULT_OK,inDatos);
        finish();

    }

}
