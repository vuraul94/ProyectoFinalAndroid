package com.example.raul9.ecopio.models;

/**
 * Created by raul94jvu on 15/6/2017.
 */


public class CategoriasCentro {

    private Integer id;
    private Integer precioKilo;
    private Integer idCentro;
    private Integer idCategoria;
    private String createdAt;
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrecioKilo() {
        return precioKilo;
    }

    public void setPrecioKilo(Integer precioKilo) {
        this.precioKilo = precioKilo;
    }

    public Integer getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
