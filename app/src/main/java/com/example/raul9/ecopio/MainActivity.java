package com.example.raul9.ecopio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_huella_verde;
    Button btn_inicio;
    Button btn_slide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_activity_main);
        btn_huella_verde = (Button) findViewById(R.id.btnHuellaVerde);
        btn_inicio = (Button) findViewById(R.id.btnInicio);
        btn_slide = (Button)findViewById(R.id.slideBtn);

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CentrosActivity.class);
                startActivity(intent);
            }
        });

        btn_huella_verde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getBaseContext(), HuellaVerdeActivity.class);
                startActivity(intent);*/
                Uri uriUrl = Uri.parse("http://www.tuhuellaecologica.org/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        btn_slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                PrefManager prefManager = new PrefManager(getApplicationContext());

                // make first time launch TRUE
                prefManager.setFirstTimeLaunch(true);

                startActivity(new Intent(MainActivity.this, SlideActivity.class));
                finish();
            }
        });

    }
}