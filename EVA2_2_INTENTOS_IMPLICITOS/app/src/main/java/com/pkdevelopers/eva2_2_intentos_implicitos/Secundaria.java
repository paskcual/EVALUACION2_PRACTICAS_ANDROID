package com.pkdevelopers.eva2_2_intentos_implicitos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Secundaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
    }

    public void cerrarSecun(View v){
        finish();
    }
}
