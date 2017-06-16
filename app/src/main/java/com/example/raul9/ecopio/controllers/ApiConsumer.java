package com.example.raul9.ecopio.controllers;

/**
 * Created by raul94jvu on 15/6/2017.
 */

public class ApiConsumer {
    public static final String BASE_URL = "http://cic.nubila.tech/api/";

    public static Servicio getServicio() {
        return Cliente.getClient(BASE_URL).create(Servicio.class);
    }
}
