package com.pkdevelopers.eva2_2_intentos_implicitos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIniSecu;
    Intent inLanzarSecun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniSecu = findViewById(R.id.btnIniciSecu);
        btnIniSecu.setOnClickListener((View.OnClickListener) this);

        inLanzarSecun = new Intent(MainActivity.this, Secundaria.class);//ahora los valores cambian, ahora queremos decirle que ejecute la segunda pantalla

    }

    @Override
    public void onClick(View v) {
        startActivity(inLanzarSecun);

    }
}
