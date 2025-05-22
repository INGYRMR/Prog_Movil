package com.example.estado_capitales;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class MainActivity extends Activity {

    /*
        ALUMNO: MERCADO ROMERO YAHIR RICARDO
        PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void actividadestados(View v){
        Intent intent = new Intent(this, Estados.class);
        startActivity(intent);
    }

    public void actividadcreditos(View v){
        Intent intent = new Intent(this, Creditos.class);
        startActivity(intent);
    }
}
