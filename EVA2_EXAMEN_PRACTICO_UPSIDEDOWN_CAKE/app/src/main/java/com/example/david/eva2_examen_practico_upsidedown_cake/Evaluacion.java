package com.example.david.eva2_examen_practico_upsidedown_cake;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class Evaluacion extends AppCompatActivity {
    TextView lblNombre, lblDesc, lblDire;
    ImageView imvImagen, imvR1, imvR2, imvR3;
    Intent inDatos;
    Intent inMostrar;
    public static int iContador = -1;
    int iPos;
    int iR1, iR2, iR3;
    public static java.util.ArrayList<GuardarEstrella> ArrayList = new ArrayList<GuardarEstrella>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        lblDesc = findViewById(R.id.lblDescripcionE);
        lblNombre = findViewById(R.id.lblNombreE);
        lblDire = findViewById(R.id.lblDireccionTelefonoE);
        imvImagen = findViewById(R.id.imvImagenE);
        imvR1 = findViewById(R.id.imvR1);
        imvR2 = findViewById(R.id.imvR2);
        imvR3 = findViewById(R.id.imvR3);

        inDatos = getIntent();

        Capturar.Restaurante restauranteVal = Capturar.ArrayList.get(inDatos.getIntExtra("POS", 0));
        iPos = inDatos.getIntExtra("POS", 0);
        lblNombre.setText(restauranteVal.sNombreResta);
        lblDesc.setText(restauranteVal.sDescripcion);
        lblDire.setText(restauranteVal.sDireccion + " tel: " + restauranteVal.sTelefono);
        imvImagen.setImageResource(restauranteVal.iImagen);

        try {
            Evaluacion.GuardarEstrella estrellitas = Evaluacion.ArrayList.get(iPos);
            if (estrellitas.iCantEstrellas == 1) {
                imvR1.setImageResource(R.drawable.estrellallena);
                iR1 = 1;
            }
            if (estrellitas.iCantEstrellas == 2) {
                imvR1.setImageResource(R.drawable.estrellallena);
                imvR2.setImageResource(R.drawable.estrellallena);
                iR2 = 1;
            }
            if (estrellitas.iCantEstrellas == 3) {
                imvR1.setImageResource(R.drawable.estrellallena);
                imvR2.setImageResource(R.drawable.estrellallena);
                imvR3.setImageResource(R.drawable.estrellallena);
                iR3 = 1;
            }
        } catch (Exception e) {
            imvR1.setImageResource(R.drawable.estrellallena);
            iR1 = 1;
        }


        inMostrar = new Intent(this, Mostrar.class);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int iCant = 0;
        if (iR3 == 1) {
            iCant = 3;
        } else if (iR2 == 1) {
            iCant = 2;
        } else if (iR1 == 1) {
            iCant = 1;
        }

        GuardarEstrella cClim = new GuardarEstrella(iCant, iPos);
        if (Estrellas.estrellas.AgregarEnLista(cClim)) {
            Toast.makeText(this, "Opinión guardada.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Opinión Actualizada.", Toast.LENGTH_SHORT).show();
        }
        startActivity(inMostrar);
    }

    public void ClickR1(View v) {
        if (iR1 == 0) {
            imvR1.setImageResource(R.drawable.estrellallena);
            iR1 = 1;
            iR3 = 0;
            iR2 = 0;
            imvR3.setImageResource(R.drawable.estrellavacia);
            imvR2.setImageResource(R.drawable.estrellavacia);

        } else {
            if (iR2 == 1) {
                imvR2.setImageResource(R.drawable.estrellavacia);
                imvR3.setImageResource(R.drawable.estrellavacia);
                iR2 = 0;
                iR3 = 0;
            } else {
                imvR1.setImageResource(R.drawable.estrellavacia);
                iR1 = 0;
            }
        }

    }

    public void ClickR2(View v) {

        if (iR2 == 0) {
            imvR2.setImageResource(R.drawable.estrellallena);
            imvR1.setImageResource(R.drawable.estrellallena);
            iR2 = 1;
            iR1 = 1;
            iR3 = 0;
            imvR3.setImageResource(R.drawable.estrellavacia);

        } else {
            if (iR3 == 1) {
                imvR3.setImageResource(R.drawable.estrellavacia);
                iR3 = 0;
            } else {
                imvR2.setImageResource(R.drawable.estrellavacia);
                iR2 = 0;
            }

        }
    }

    public void ClickR3(View v) {
        if (iR3 == 0) {
            imvR3.setImageResource(R.drawable.estrellallena);
            imvR2.setImageResource(R.drawable.estrellallena);
            imvR1.setImageResource(R.drawable.estrellallena);
            iR3 = 1;
            iR2 = 1;
            iR1 = 1;
        } else {
            imvR3.setImageResource(R.drawable.estrellavacia);
            iR3 = 0;
        }

    }

    public static class Estrellas {
        static Estrellas estrellas = new Estrellas();


        @TargetApi(Build.VERSION_CODES.N)
        @RequiresApi(api = Build.VERSION_CODES.N)
        public boolean AgregarEnLista(GuardarEstrella rResta) {

            if (BuscarEnLista(rResta) == false) {
                ArrayList.add(rResta);
                iContador++;

                return true;
            } else {
                ArrayList.set(rResta.iPos, rResta);

            }
            return false;

        }

        public boolean BuscarEnLista(GuardarEstrella iEstrellas) {
            GuardarEstrella iVal;

            for (int i = 0; i <= iContador; i++) {
                iVal = ArrayList.get(i);
                if (iVal.iPos == iEstrellas.iPos) {
                    return true;
                }
            }
            return false;
        }

    }

    public static class GuardarEstrella {
        int iCantEstrellas;
        int iPos;

        public GuardarEstrella(int iCantEstrellas, int iPos) {
            this.iCantEstrellas = iCantEstrellas;
            this.iPos = iPos;
        }
    }
}
