package com.pkdevelopers.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Secundaria extends AppCompatActivity implements ListView.OnItemClickListener{

    //INICIALIZAMOS LISTVIEW
    ListView lstResta;
    //INICIALIZAMOS UN INTENTO
    Intent inDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        //ENLAZAMOS LAS VARIABLES
        lstResta = findViewById(R.id.lstResta);

        //CREAR EL ADAPTADOR
        //ASIGNAMOS EL ADAPTADOR
        lstResta.setAdapter(new ArrayAdapter<String>(
                this,//ESTABLECEMOS CONTEXTO
                android.R.layout.simple_list_item_1,//ESTABLECEMOS EL TIPO DE LISTA
                Datos.sResta));//OBTENEMOS LOS DATOS DE LA CLASE DATOS.JAVA
        //ASIGNAMOS EL LISTENER
        lstResta.setOnItemClickListener(this);

        //OBTENEMOS EL INTENTO PARA INDATOS
        inDatos = getIntent();

    }

    //METODO PARA CUANDO SELECCIONEMOS UN RESTAURANTE EN LA LISTA
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        inDatos.putExtra("RESTAURANTE", position);
        setResult(Activity.RESULT_OK, inDatos);
        finish();//ES OPCIONAL

    }
}
