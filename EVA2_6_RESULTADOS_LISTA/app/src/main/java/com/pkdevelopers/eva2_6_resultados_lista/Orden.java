package com.pkdevelopers.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Orden extends AppCompatActivity {

    EditText etxtCant, etxtPrecio;
    Intent inDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);

        etxtCant = findViewById(R.id.etxtCantidad);
        etxtPrecio = findViewById(R.id.etxtPrecio);

        inDatos = getIntent();

    }

    public void calculaCosto(View view){
        int iCant = Integer.parseInt(etxtCant.getText().toString());
        double dPrecio = Double.parseDouble(etxtPrecio.getText().toString());
        inDatos.putExtra("TOTAL", (iCant * dPrecio));

        setResult(Activity.RESULT_OK, inDatos);
        finish();

    }

}
