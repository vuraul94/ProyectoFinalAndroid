package com.example.raul9.ecopio.controllers;

import com.example.raul9.ecopio.models.Categoria;
import com.example.raul9.ecopio.models.CategoriasCentro;
import com.example.raul9.ecopio.models.Centro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by raul94jvu on 15/6/2017.
 */

public interface Servicio {
    @GET("centros/")
    Call<List<Centro>> getCentros();

    @GET("centros/{id}")
    Call<Centro> getCentro(@Path("id") int id);

    @GET("categoriaCentros/")
    Call<List<CategoriasCentro>> getCatCentro();

    @GET("categorias/{id}")
    Call<Categoria> getCategoria(@Path("id") int id);

    @GET("categorias")
    Call<List<Categoria>> getCategorias();
}
