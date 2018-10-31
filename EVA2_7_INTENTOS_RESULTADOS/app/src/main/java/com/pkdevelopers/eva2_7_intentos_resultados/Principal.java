package com.pkdevelopers.eva2_7_intentos_resultados;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    //Variables creadas
    TextView txtResu;
    Intent inContactos, inImagenes;
    Uri uContactos, uImagenes;
    final int BUSCAR_CONTACTOS = 1000;
    final int BUSCAR_IMAGENES = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Vinculamos
        txtResu = findViewById(R.id.txtResu);

        //Uri de contactos, informacion
        uContactos = ContactsContract.Contacts.CONTENT_URI;
        //Intento de contactos
        inContactos = new Intent(Intent.ACTION_PICK, uContactos);

        //Uri de donde se ubica la informacion
        uImagenes = Uri.parse("content://media/external/images/media/");
        //Intento de imagenes
        inImagenes = new Intent(Intent.ACTION_PICK, uImagenes);

    }

    //Evento para boton de contactos
    public void click(View v) {
        startActivityForResult(inContactos, BUSCAR_CONTACTOS);
    }

    //Evento para boton de imagenes
    public void clickImagenes(View v) {
        startActivityForResult(inImagenes, BUSCAR_IMAGENES);
    }

    //Se ejecuta despues de el startActivityForResult
    @SuppressLint("MissingPermission")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case BUSCAR_CONTACTOS:
                if (resultCode == Activity.RESULT_OK) {
                    String sResu = data.getDataString();
                    txtResu.setText(sResu);

                    //CODIGO MIO
                    Intent myActivity2 = new Intent(Intent.ACTION_CALL, Uri.parse(sResu));
                    startActivity(myActivity2);


                }
                break;

            case BUSCAR_IMAGENES:
                if(resultCode == Activity.RESULT_OK){
                    String sResu = data.getDataString();
                    txtResu.setText(sResu);

                    //CODIGO MIO
                    Intent intent = new Intent();
                    intent.setType(sResu);
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivity(intent);

                }
                break;

        }


    }
}
