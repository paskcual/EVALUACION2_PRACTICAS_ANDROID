package com.pkdevelopers.eva2_4_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener, View.OnClickListener{

    TextView txtSalario;
    EditText etxtNombre, etxtApellido, etxtEdad, etxtSalario;
    CheckBox chbxLaboraActualmente;
    RadioGroup rdgpGenero;
    Button btnEnviar;
    Intent inEnvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VINCULAMOS
        txtSalario = findViewById(R.id.txtSalario);
        etxtNombre = findViewById(R.id.etxtNombre);
        etxtApellido = findViewById(R.id.etxtApellido);
        etxtEdad = findViewById(R.id.etxtEdad);
        etxtSalario = findViewById(R.id.etxtSalario);
        btnEnviar = findViewById(R.id.btnEnviar);
        chbxLaboraActualmente = findViewById(R.id.chbxLaboraActualmente);
        rdgpGenero = findViewById(R.id.rdgpGenero);

        //AGREGAMOS UN CLICK LISTENER
        btnEnviar.setOnClickListener(this);

        //AGREGAMOS UN ONCHECKEDCHANGELISTENER
        chbxLaboraActualmente.setOnCheckedChangeListener(this);

        //CREAMOS UN NUEVO INTENTO
        inEnvar = new Intent(this,Secundaria.class);


    }

    //EVENTO CUANDO PRESIONAMOS EL BOTON
    @Override
    public void onClick(View v) {

        //OBTENEMOS LOS VALORES ESCRITOS
        String sNom = etxtNombre.getText().toString();
        String sApe = etxtApellido.getText().toString();
        int iEdad = Integer.parseInt(etxtEdad.getText().toString());
        boolean bLabora = chbxLaboraActualmente.isChecked();
        double dSal = Double.parseDouble(etxtSalario.getText().toString());

        //CREAMOS VARIABLES DE COMPARACION PARA ASIGNAR EL GENERO
        int iSel = rdgpGenero.getCheckedRadioButtonId();
        int iGen;

        if(iSel == R.id.rdbtnMasculino){
            iGen = 1;
        }else if(iSel == R.id.rdbtnFemenino){
            iGen = 2;
        }else{
            iGen = 3;
        }

        //CREAMOS UN NUEVO BUNDLE
        Bundle bBundle = new Bundle();
        //PONEMOS VALORES A BUNDLE
        bBundle.putString("NOMBRE",sNom);
        bBundle.putString("APELLIDO",sApe);
        bBundle.putInt("EDAD",iEdad);
        bBundle.putBoolean("LABORA",bLabora);
        bBundle.putDouble("SALARIO",dSal);
        bBundle.putInt("GENERO",iGen);
        inEnvar.putExtras(bBundle);
        //EMPEZAMOS LA ACTIVIDAD
        startActivity(inEnvar);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        txtSalario.setEnabled(chbxLaboraActualmente.isChecked());
        etxtSalario.setEnabled(chbxLaboraActualmente.isChecked());

    }
}
