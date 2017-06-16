package com.example.raul9.ecopio;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.raul9.ecopio.controllers.ApiConsumer;
import com.example.raul9.ecopio.controllers.Servicio;
import com.example.raul9.ecopio.models.Categoria;
import com.example.raul9.ecopio.models.CategoriasCentro;
import com.example.raul9.ecopio.models.Centro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleCentrosActivity extends AppCompatActivity {

    private Servicio servicio;

    Call<Centro> centro;
    Call<List<CategoriasCentro>> cats_centro;
    Call<List<Categoria>> categorias;
    List<Categoria> lista_categorias;
    ArrayList<Categoria> centro_categorias;
    Button btn_atras, btn_ruta;
    TextView nombre, direccion, telefono, express, categoria;
    int centro_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_centros);
        Bundle extras = getIntent().getExtras();
        servicio = ApiConsumer.getServicio();
        centro = servicio.getCentro(extras.getInt("id"));
        cats_centro = servicio.getCatCentro();
        categorias = servicio.getCategorias();
        nombre = (TextView) findViewById(R.id.txtNombre);
        direccion = (TextView) findViewById(R.id.txtDireccion);
        telefono = (TextView) findViewById(R.id.txtTelefono);
        express = (TextView) findViewById(R.id.txtEstado);
        categoria = (TextView) findViewById(R.id.txtCategoria);
        btn_atras = (Button) findViewById(R.id.btnAtras);
        btn_ruta = (Button) findViewById(R.id.btnRuta);
        centro_categorias= new ArrayList<Categoria>();

        centro.enqueue(new Callback<Centro>() {

            @Override
            public void onResponse(Call<Centro> call, Response<Centro> response) {
                Centro centroB = response.body();
                setData(centroB);
            }


            @Override
            public void onFailure(Call<Centro> call, Throwable t) {
                Log.d("CentrosActivity", "API Fail");
            }
        });

        categorias.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                lista_categorias=response.body();
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {

            }
        });

        cats_centro.enqueue(new Callback<List<CategoriasCentro>>() {
            @Override
            public void onResponse(Call<List<CategoriasCentro>> call, Response<List<CategoriasCentro>> response) {
                List<CategoriasCentro> cats_centro =response.body();
                for(int i=0;i<cats_centro.size();i++){
                    if(cats_centro.get(i).getIdCentro()== centro_id){
                        for (int n=0;n<lista_categorias.size();n++){
                            if(cats_centro.get(i).getIdCategoria()== lista_categorias.get(n).getId()){
                                centro_categorias.add(lista_categorias.get(n));
                            }
                        }
                    }
                }
                String categ_data="";
                for(int i=0;i<centro_categorias.size();i++){
                    if(i!=(centro_categorias.size()-1)){
                        categ_data=categ_data+centro_categorias.get(i).getDescripcion()+", ";
                    }else{
                        categ_data=categ_data+centro_categorias.get(i).getDescripcion()+".";
                    }

                }

                categoria.setText(categ_data);

            }

            @Override
            public void onFailure(Call<List<CategoriasCentro>> call, Throwable t) {

            }
        });

        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    public void setData(final Centro centro){
        nombre.setText(centro.getNombre());
        direccion.setText(centro.getDireccion());
        telefono.setText(centro.getTelefono());
        express.setText(centro.getExpress());
        btn_ruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleCentrosActivity.this, RutaActivity.class);
                i.putExtra("lat",centro.getLatitud());
                i.putExtra("long",centro.getLongitud());
                startActivity(i);
            }
        });

        centro_id=centro.getId();

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
