package com.example.david.eva2_examen_practico_upsidedown_cake;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Capturar extends AppCompatActivity {
    //COMPONENTES
    public static ImageView imgLista;
    public static int iImagen;
    public static EditText txtNombre, txtDescripcion, txtDireccion, txtTelefono;
    Button btnGuardar;
    public static ArrayList<Restaurante> ArrayList = new ArrayList<Restaurante>();
    public static int iContador = -1;
    //INTENTO
    Intent inListaResta, inRecibeFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);

        //INSTANCIAR LOS COMPONENTES
        imgLista = findViewById(R.id.imgLista);
        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtTelefono = findViewById(R.id.txtTelefono);

        //IMAGEN DE PANTALLA PRINCIPAL
        imgLista.setImageResource(R.drawable.lista);
        iImagen = R.drawable.lista;

        //INTENTO PARA SELECCIONAR IMAGEN DE LA LISTA
        inListaResta = new Intent(this, ListaRestaSelec.class);
        //INTENTO RECIBIDO DE LA LISTA DE IMAGENES
        inRecibeFoto = getIntent();

        //EXTRAS
        imgLista.setImageResource(inRecibeFoto.getIntExtra("FOTO", R.drawable.lista));
        iImagen = inRecibeFoto.getIntExtra("FOTO", R.drawable.lista);
    }

    //METODO DE LA IMAGEN PARA ABRIR LISTA
    public void Clicklistaimg(View v) {
        //EMPEZAR LA ACTIVIDAD
        startActivity(inListaResta);
    }

    //METODO DEL BOTON GUARDAR
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Clickguardar(View v) {
        if (iImagen != R.drawable.lista) {
            if (txtNombre.getText().toString().equals("") || txtDescripcion.getText().toString().equals("")
                    || txtDireccion.getText().toString().equals("") || txtTelefono.getText().toString().equals("")) {
                Toast.makeText(this, "Debe llenar todos los campos.", Toast.LENGTH_SHORT).show();
            } else {
                Restaurante cClim = new Restaurante(txtNombre.getText().toString(), txtDescripcion.getText().toString(), iImagen, txtDireccion.getText().toString(), txtTelefono.getText().toString());
                if (ClaseArrayList.ClaseArrayList.AgregarEnLista(cClim)) {
                    Toast.makeText(this, "Restaurante guardado.", Toast.LENGTH_SHORT).show();
                    finish();
                    iImagen = R.drawable.lista;
                } else {
                    Toast.makeText(this, "Ese restaurante ya fue guardado prueba con otro", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(this, "Cambia de imagen para continuar", Toast.LENGTH_SHORT).show();
        }
    }


    public static class ClaseArrayList {
        static ClaseArrayList ClaseArrayList = new ClaseArrayList();


        @TargetApi(Build.VERSION_CODES.N)
        @RequiresApi(api = Build.VERSION_CODES.N)
        public boolean AgregarEnLista(Restaurante rResta) {

            if (BuscarEnLista(rResta) == false) {
                ArrayList.add(rResta);
                iContador++;
                String sInfo = String.valueOf(ArrayList.size());
                return true;
            }
            return false;

        }

        public boolean BuscarEnLista(Restaurante rResta) {
            Restaurante restauranteVal;
            for (int i = 0; i <= iContador; i++) {
                restauranteVal = ArrayList.get(i);
                if (restauranteVal.iImagen == rResta.iImagen) {
                    return true;
                }
            }
            return false;
        }

    }

    public static class Restaurante {
        String sNombreResta;
        String sDescripcion;
        int iImagen;
        String sDireccion;
        String sTelefono;

        public Restaurante(String sNombreResta, String sDescripcion, int iImagen, String sDireccion, String sTelefono) {
            this.sNombreResta = sNombreResta;
            this.sDescripcion = sDescripcion;
            this.iImagen = iImagen;
            this.sDireccion = sDireccion;
            this.sTelefono = sTelefono;
        }
    }
}
