package com.example.programa3;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;

/*
   ALUMNO: MERCADO ROMERO YAHIR RICARDO
   PROGRAMACIÓN MOVÍL, GURPO: 2807
*/

public class BolitaImagenAnimada extends Activity {

    private ImageView animationView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bolitaimagenanimada);

        animationView = findViewById(R.id.idbolitaimagenanimada);
        animationDrawable = (AnimationDrawable) animationView.getDrawable();


        animationView.post(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        });
    }
}
