package com.pkdevelopers.eva2_10_cuadros_dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void clickCuadroGeneral(View v) {
        new AlertDialog.Builder(this).setTitle("MI CUADRO DE DIALOGO")
                .setMessage("Cuadro de dialogo genral")
                .setPositiveButton("POSITIVO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "CLICKASO POSITIVO!!!!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("NEUTRAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "CLICKASO NEUTRAL!!!!", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("NEGATIVO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "CLICKASO NEGATIVO!!!!", Toast.LENGTH_SHORT).show();
            }
        }).create().show();

    }

    public void clickCuadroCuadroPerso(View v) {
        final Dialog dMiCuadroDialogo = new Dialog(this);
        dMiCuadroDialogo.setContentView(R.layout.mi_cuadro_dialogo);

        TextView txtTitulo;
        final EditText etxtDatos;
        Button btnAccion;

        txtTitulo = dMiCuadroDialogo.findViewById(R.id.txtTitulo);
        etxtDatos = dMiCuadroDialogo.findViewById(R.id.etxtCaptura);
        btnAccion = dMiCuadroDialogo.findViewById(R.id.btnOk);

        txtTitulo.setText("MI CUADRO PERSONALIZADO");
        etxtDatos.setHint("Introduce tu nombre");
        btnAccion.setText("SALUDAR!");

        btnAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), etxtDatos.getText().toString(), Toast.LENGTH_SHORT).show();
                dMiCuadroDialogo.dismiss();
            }
        });
        dMiCuadroDialogo.show();

    }

}
