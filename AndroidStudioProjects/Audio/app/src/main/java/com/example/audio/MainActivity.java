package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

     /*
        ALUMNO: MERCADO ROMERO YAHIR RICARDO
        PROGRAMACIÓN MOVÍL, GRUPO: 2807
    */

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.gato);
    }

    public void ejecutar(View v) {
        if (mp != null) {
            mp.start();
        }
    }
}
