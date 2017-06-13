package com.example.raul9.ecopio;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class CentrosActivity extends AppCompatActivity {

    Button btn_atras;
    ListView list_Centros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_centros);
        btn_atras = (Button) findViewById(R.id.btnAtrasC);
        list_Centros = (ListView) findViewById(R.id.listCentros);

        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        /**************/
         TabHost host = (TabHost)findViewById(R.id.tabhost);
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
            if(i==1){
                v.setBackgroundResource(R.drawable.ic_btn_pres);
            }else{
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
        /***************/

        String[] values = new String[] {
                "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        list_Centros.setAdapter(adapter);
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
}
