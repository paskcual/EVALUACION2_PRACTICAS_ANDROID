package com.pkdevelopers.eva2_10_practica_restaurante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener{

    Intent inDetalle;

    Restaurante[] aRestaurante = {
            new Restaurante("Barrafina","Restaurant Gourmet","Periferico de la juventud #564","Distrito 1", "6143544875",R.drawable.barrafina),
            new Restaurante("Bourkestreetbakery","Cafe Gourmet","Arboledas #234", "Distrito 2", "6147895414",R.drawable.bourkestreetbakery),
            new Restaurante("Cafedeadend","Pizzas Tradicionaes","Arco del norte #256","Distrito 3","6142144556",R.drawable.cafedeadend),
            new Restaurante("Cafelosil","Restaurant Gourmet","Senda arcoiris #567","Distrito 1", "6145877416",R.drawable.cafeloisl),
            new Restaurante("Cafelore","Cafe Gourmet","La vida no es facil #653","Distrito 2", "6149874865",R.drawable.cafelore),
            new Restaurante("Confessional","Pizzas Tradicionales","Desierto #443","Distrito 3","6149877448",R.drawable.confessional),
            new Restaurante("Donostia","Restaurant Gourmet","Pasa el tiempo #111", "Distrito 1", "6144877447",R.drawable.donostia),
            new Restaurante("Fiveleaves","Cafe Gourmet","Agradecidos #221","Distrito 2", "6145844721", R.drawable.fiveleaves),
            new Restaurante("Forkeerestaurant","Pizzas Tradicionales","Familia #443","Distrito 3", "6146988475",R.drawable.forkeerestaurant),
            new Restaurante("Grahamavenuemeats","Restaurant Gourmet","Ojos tristes #213","Distrito 1", "6149853214", R.drawable.grahamavenuemeats),
            new Restaurante("Haighschocolate","Cafe Gourmet","Poderosos #472","Distrito 2", "6145877431",R.drawable.haighschocolate),
            new Restaurante("Homei","Pizzas Tradicionales","De botitas y sombrero #983","Distrito 3", "6149853102", R.drawable.homei),
            new Restaurante("Palominoespresso","Restaurant Gourmet","Botellon #454","Distrito 1","6143021403",R.drawable.palominoespresso),
            new Restaurante("Petiteoyster","Cafe Gourmet","Mexicanos #452","Distrito 2","6143010778",R.drawable.petiteoyster),
            new Restaurante("Posatelier","Pizzas Tradicionales","Vengo a aclarar #672","Distrito 3","6143844001",R.drawable.posatelier),
            new Restaurante("Royaloak","Restaurant Gourmet","Bueno o malo #451","Distrito 1", "6140329814",R.drawable.royaloak),
            new Restaurante("Teakha","Cafe Gourmet","King k rook #692","Distrito 2","6140325469",R.drawable.teakha),
            new Restaurante("Thaicafe","Pizzas Tradicionales","Navego el volante #101","Distrito 3", "6148752365",R.drawable.thaicafe),
            new Restaurante("Traif","Restaurant Gourmet","Wacha tus amigos #999","Distrito 1","6143021447",R.drawable.traif),
            new Restaurante("Upstate","Cafe Gourmet","Help me #090","Distrito 2","6143588714",R.drawable.upstate),
            new Restaurante("Wafflewolf","Pizzas Tradicionales","Como nos pesa #222","Distrito 3","6148799878",R.drawable.wafflewolf)
    };

    ListView lstvwRestaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lstvwRestaurantes = findViewById(R.id.lstvwRestaurantes);

        //asignamos el adaptador
        lstvwRestaurantes.setAdapter(new AdaptadorRestaurante(this, R.layout.layout_restaurante, aRestaurante));

        lstvwRestaurantes.setOnItemClickListener(this);
        inDetalle = new Intent(this,RestauranteDetalle.class);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        inDetalle.putExtra("IMAGEN", aRestaurante[position].imagen);
        inDetalle.putExtra("NOMBRE",aRestaurante[position].nombreRest);
        inDetalle.putExtra("TIPO",aRestaurante[position].tipoRest);
        inDetalle.putExtra("UBICACION", aRestaurante[position].ubicacionRest);
        inDetalle.putExtra("DISTRITO", aRestaurante[position].distritoRest);
        inDetalle.putExtra("TELEFONO", aRestaurante[position].telRest);

        startActivity(inDetalle);

    }
}
