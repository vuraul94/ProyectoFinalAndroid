package com.example.raul9.ecopio.models;

/**
 * Created by raul94jvu on 15/6/2017.
 */

import java.util.List;

public class CIC {

    private List<Centro> centros = null;
    private List<Categoria> categorias = null;
    private List<CategoriasCentro> categoriasCentros = null;
    private List<Usuario> usuarios = null;

    public List<Centro> getCentros() {
        return centros;
    }

    public void setCentros(List<Centro> centros) {
        this.centros = centros;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<CategoriasCentro> getCategoriasCentros() {
        return categoriasCentros;
    }

    public void setCategoriasCentros(List<CategoriasCentro> categoriasCentros) {
        this.categoriasCentros = categoriasCentros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
