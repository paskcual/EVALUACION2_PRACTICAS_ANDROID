package com.pkdevelopers.eva2_1_intentos;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    EditText etxtTel;
    Intent inMarcar;//se declaran porque son objetos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtTel = findViewById(R.id.etxtTel);

    }

    public void miClick(View v){
        String sTel = etxtTel.getText().toString();
        sTel = "tel: " + sTel;

        inMarcar = new Intent(Intent.ACTION_DIAL, Uri.parse(sTel));//tenemos que construir el intento, normalmente piden 2 valores(accion, datos)
        //inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));//este metodo lama, pero necesito los permisos
        //EJECUTAR EL INTENTO
        //QUIEREN UNA RESPUESTA, SI O NO,
        startActivity(inMarcar);
        //si esperamos un resutado
        //startActivityForResult();
    }

    public void otroClick(View v){
        String sTel = etxtTel.getText().toString();
        sTel = "tel: " + sTel;

        inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));//tenemos que construir el intento, normalmente piden 2 valores(accion, datos)
        startActivity(inMarcar);


    }

    public void webOnClick(View v){
        inMarcar = new Intent(Intent.ACTION_WEB_SEARCH);//tenemos que construir el intento, normalmente piden 2 valores(accion, datos)
        inMarcar.putExtra(SearchManager.QUERY, "taquitos");//extras son como mapas en java, son valores (coomo valores dobles, coordenadas), nombre identifica el dato y valor es valor
        startActivity(inMarcar);

    }

}
