package com.example.raul9.ecopio;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.raul9.ecopio.controllers.ApiConsumer;
import com.example.raul9.ecopio.controllers.ListAdapter;
import com.example.raul9.ecopio.controllers.Servicio;
import com.example.raul9.ecopio.models.Centro;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CentrosActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Servicio servicio;

    Call<List<Centro>> centros;
    Button btn_atras;
    ListView list_Centros;
    List<Centro> centros_lista;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_centros);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        servicio = ApiConsumer.getServicio();
        btn_atras = (Button) findViewById(R.id.btnAtrasC);
        list_Centros = (ListView) findViewById(R.id.listCentros);

        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TabHost host = (TabHost) findViewById(R.id.tabhost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Mapa");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Mapa");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Cerca");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Cerca");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Acerca");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Acerca");
        host.addTab(spec);

        host.setCurrentTab(1);

        for (int i = 0; i < host.getTabWidget().getChildCount(); i++) {
            View v = host.getTabWidget().getChildAt(i);
            if (i == 1) {
                v.setBackgroundResource(R.drawable.ic_btn_pres);
            } else {
                v.setBackgroundResource(R.drawable.ic_btn_norm);
            }
            TextView tv = (TextView) host.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#bdbdbd"));
            final int finalI = i;
            v.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    changeColorTab(v, finalI);
                }
            });

        }

        centros = servicio.getCentros();



        centros.enqueue(new Callback<List<Centro>>() {

            @Override
            public void onResponse(Call<List<Centro>> call, Response<List<Centro>> response) {
                setList(response.body());
            }


            @Override
            public void onFailure(Call<List<Centro>> call, Throwable t) {
                Log.d("CentrosActivity", "API Fail");
            }
        });
    }


    public void setList(final List<Centro> centros){
        ListAdapter adapter = new ListAdapter(this,R.layout.item,centros);
        list_Centros.setAdapter(adapter);

        list_Centros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Centro centro = centros.get(position);
                Intent i = new Intent(CentrosActivity.this,DetalleCentrosActivity.class);
                i.putExtra("id", centro.getId());
                startActivity(i);
            }
        });

        LatLng centro1 = new LatLng(0,0);
        for(int i=0;i<centros.size();i++){
            Centro centro = centros.get(i);
            LatLng centroCord = new LatLng(centro.getLatitud(),centro.getLongitud());
            MarkerOptions marker= new MarkerOptions().position(centroCord).title(centro.getNombre());
            mMap.addMarker(marker);
            if(i==0){
                centro1= centroCord;
            }
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(centro1));

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void changeColorTab(View v,int tab){

        TabHost host = (TabHost)findViewById(R.id.tabhost);
        for (int i = 0; i < host.getTabWidget().getChildCount(); i++) {
            View vi = host.getTabWidget().getChildAt(i);
            vi.setBackgroundResource(R.drawable.ic_btn_norm);
        }
        v.setBackgroundResource(R.drawable.ic_btn_pres);
        host.setCurrentTab(tab);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}
