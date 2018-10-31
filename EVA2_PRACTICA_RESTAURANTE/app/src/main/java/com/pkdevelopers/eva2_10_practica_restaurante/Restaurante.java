package com.pkdevelopers.eva2_10_practica_restaurante;

public class Restaurante {

    String nombreRest;
    String tipoRest;
    String ubicacionRest;
    String distritoRest;
    String telRest;
    int imagen;


    public Restaurante(String nombreRest, String tipoRest, String ubicacionRest, String distritoRest, String telRest,int imagen){

        this.nombreRest = nombreRest;
        this.tipoRest = tipoRest;
        this.ubicacionRest = ubicacionRest;
        this.distritoRest = distritoRest;
        this.telRest = telRest;
        this.imagen = imagen;

    }

}