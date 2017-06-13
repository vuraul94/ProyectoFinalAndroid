package com.example.raul9.ecopio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class CentrosActivity extends AppCompatActivity {

    Button btn_atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_centros);
        btn_atras = (Button) findViewById(R.id.btnAtrasC);

        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        /**************
        tabs.setup();


        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab2);
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
        ***************/
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
