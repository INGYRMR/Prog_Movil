package com.example.galeria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class galeria extends Activity {

    /*
        ALUMNO: MERCADO ROMERO YAHIR RICARDO
        PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    ImageView imagenactual;
    TextView descripcion;
    int ci = 0;
    String[] nombres = {"CR7", "NEYMAR", "POGBA"};
    int[] imagenes = { R.drawable.cr7, R.drawable.neymar, R.drawable.pogba};

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.migaleria);

        imagenactual = findViewById(R.id.img1);
        descripcion = findViewById(R.id.tv1);


        imagenactual.setImageResource(imagenes[ci]);
        descripcion.setText(nombres[ci]);
    }

    /*
        ALUMNO: MERCADO ROMERO YAHIR RICARDO
        PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */


    public void atras(View v) {
        if (ci == 0) {
            ci = imagenes.length - 1;
        } else {
            ci--;
        }
        imagenactual.setImageResource(imagenes[ci]);
        descripcion.setText(nombres[ci]);
    }

    public void adelante(View v) {
        if (ci == imagenes.length - 1) {
            ci = 0;
        } else {
            ci++;
        }
        imagenactual.setImageResource(imagenes[ci]);
        descripcion.setText(nombres[ci]);
    }
}

