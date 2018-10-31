package com.pkdevelopers.eva2_10_practica_restaurante;

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
import android.widget.ImageView;
import android.widget.TextView;

public class RestauranteDetalle extends AppCompatActivity {

    Intent inLlamar;
    final int PERMISO_LEER_CONTACTOS = 100;
    boolean bBande = false;

    Intent inDatos;
    ImageView imgvwRestDetalle;
    TextView txtNombreDetalle, txtTipoDetalle, txtUbicacionDetalle, txtDistritoDetalle, txtTelefonoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_detalle);

        imgvwRestDetalle = findViewById(R.id.imgvwImagenDetalle);
        txtNombreDetalle = findViewById(R.id.txtNombreDetalle);
        txtTipoDetalle = findViewById(R.id.txtTipoDetalle);
        txtUbicacionDetalle = findViewById(R.id.txtUbicacionDetalle);
        txtDistritoDetalle = findViewById(R.id.txtDistritoDetalle);
        txtTelefonoDetalle = findViewById(R.id.txtTelDetalle);
        inDatos = getIntent();

        imgvwRestDetalle.setImageResource(inDatos.getIntExtra("IMAGEN", R.drawable.barrafina));
        txtNombreDetalle.setText(inDatos.getStringExtra("NOMBRE"));
        txtTipoDetalle.setText(inDatos.getStringExtra("TIPO"));
        txtUbicacionDetalle.setText(inDatos.getStringExtra("UBICACION"));
        txtDistritoDetalle.setText(inDatos.getStringExtra("DISTRITO"));
        txtTelefonoDetalle.setText(inDatos.getStringExtra("TELEFONO"));

        //SOLICITAMOS EL PERMISO, SI NOS LO DA....
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISO_LEER_CONTACTOS);

        } else {
            bBande = true;
        }


        txtTelefonoDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_no = txtTelefonoDetalle.getText().toString().replaceAll("-", "");
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone_no));


                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //VERIFICAMOS PRIMERO
        if(requestCode == PERMISO_LEER_CONTACTOS){

            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                bBande = true;

            }

        }

    }



}
