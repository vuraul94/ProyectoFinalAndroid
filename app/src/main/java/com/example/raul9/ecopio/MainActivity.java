package com.example.raul9.ecopio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_huella_verde;
    Button btn_inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_activity_main);
        btn_huella_verde = (Button) findViewById(R.id.btnHuellaVerde);
        btn_inicio = (Button) findViewById(R.id.btnInicio);

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
                Intent intent = new Intent(getBaseContext(), HuellaVerdeActivity.class);
                startActivity(intent);
            }
        });
    }
}