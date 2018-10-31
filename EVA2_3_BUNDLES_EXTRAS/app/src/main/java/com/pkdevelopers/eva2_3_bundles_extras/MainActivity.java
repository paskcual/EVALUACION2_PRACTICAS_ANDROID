package com.pkdevelopers.eva2_3_bundles_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etxtMensaje;
    Button btnIniSecu;
    Intent inLanzarSecun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniSecu = findViewById(R.id.btnIniciSecu);
        btnIniSecu.setOnClickListener((View.OnClickListener) this);

        inLanzarSecun = new Intent(MainActivity.this, Secundaria.class);//ahora los valores cambian, ahora queremos decirle que ejecute la segunda pantalla

        etxtMensaje = findViewById(R.id.etxtMensa);

    }

    @Override
    public void onClick(View v) {
        String sCade = etxtMensaje.getText().toString();//como ponemos esto dentro del intento? con los extras
        inLanzarSecun.putExtra("MENSAJE",sCade);
        startActivity(inLanzarSecun);

    }

}
