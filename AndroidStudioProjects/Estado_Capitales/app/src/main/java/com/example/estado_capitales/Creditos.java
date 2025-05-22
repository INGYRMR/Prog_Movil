package com.example.estado_capitales;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Creditos extends Activity {

     /*
         ALUMNO: MERCADO ROMERO YAHIR RICARDO
         PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.layout);
    }
    public void regresar_principal(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
