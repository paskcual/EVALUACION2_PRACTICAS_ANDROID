package com.pkdevelopers.eva2_9_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    EditText etxtTel;
    Intent inLlamar;
    final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    boolean bBande = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etxtTel = findViewById(R.id.etxtTel);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            //solicitamos el permiso
            // No explanation needed, we can request the permission.

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.

        } else {
            bBande = true;
        }

    }


    public void click(View v) {
        if (bBande) {
            String sTel = "tel: " + etxtTel.getText().toString();
            inLlamar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
            startActivity(inLlamar);

        } else {
            Toast.makeText(this, "NO TIENES PERMISOS PARA LLAMAR", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //primero verificamos
        if (requestCode == MY_PERMISSIONS_REQUEST_READ_CONTACTS) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                bBande = true;
                // permission was granted, yay! Do the
                // contacts-related task you need to do.

            }


        }
    }

}
