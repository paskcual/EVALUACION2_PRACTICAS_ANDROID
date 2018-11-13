package com.example.david.eva2_examen_practico_upsidedown_cake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListaRestaSelec extends AppCompatActivity implements ListView.OnItemClickListener {
    //COMPONENTES
    ListView lstFotosResta;
    //INTENTO
    Intent inFotoSelec;

    //ARREGLO DE LAS FOTOS DE LOS RESTAURANTES A SELECCIONAR
    Listafotos[] lFotos = {
            new Listafotos(R.drawable.barrafina),
            new Listafotos(R.drawable.bourkestreetbakery),
            new Listafotos(R.drawable.cafedeadend),
            new Listafotos(R.drawable.cafeloisl),
            new Listafotos(R.drawable.cafelore),
            new Listafotos(R.drawable.confessional),
            new Listafotos(R.drawable.donostia),
            new Listafotos(R.drawable.fiveleaves),
            new Listafotos(R.drawable.forkeerestaurant),
            new Listafotos(R.drawable.grahamavenuemeats),
            new Listafotos(R.drawable.haighschocolate),
            new Listafotos(R.drawable.homei),
            new Listafotos(R.drawable.palominoespresso),
            new Listafotos(R.drawable.petiteoyster),
            new Listafotos(R.drawable.posatelier),
            new Listafotos(R.drawable.royaloak),
            new Listafotos(R.drawable.teakha),
            new Listafotos(R.drawable.thaicafe),
            new Listafotos(R.drawable.traif),
            new Listafotos(R.drawable.upstate),
            new Listafotos(R.drawable.wafflewolf)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_resta_selec);

        //LISTA
        lstFotosResta = findViewById(R.id.lstFotosResta);
        lstFotosResta.setOnItemClickListener(this);
        lstFotosResta.setAdapter(new Adaptador(this, R.layout.listaresta, lFotos));

        //INTENTO
        inFotoSelec = new Intent(this, Capturar.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int iImagen = lFotos[position].iFoto;
        inFotoSelec.putExtra("FOTO", iImagen);
        startActivity(inFotoSelec);
        finish();
    }
}
