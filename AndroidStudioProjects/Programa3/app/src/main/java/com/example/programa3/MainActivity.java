package com.example.programa3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.widget.TextView;

/*
ALUMNO: MERCADO ROMERO YAHIR RICARDO
PROGRAMACIÓN MOVÍL, GURPO: 2807
 */

public class MainActivity extends Activity implements OnClickListener {
    Button b1, b2, b3;

    public void onCreate(Bundle si){
        super.onCreate(si);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView titulo = new TextView(this);
        titulo.setText("Bolitas");
        titulo.setTextSize(40);
        ll.addView(titulo);

        b1 = new Button(this);
        b1.setText("Bolita JAVA");
        b1.setOnClickListener(this);

        b2 = new Button(this);
        b2.setText("Bolita Imagen");
        b2.setOnClickListener(this);

        b3 = new Button(this);
        b3.setText("Bolita Imagen Animada");
        b3.setOnClickListener(this);

        ll.addView(b1);
        ll.addView(b2);
        ll.addView(b3);

        setContentView(ll);
    }

    /*
    ALUMNO: MERCADO ROMERO YAHIR RICARDO
    PROGRAMACIÓN MOVÍL, GURPO: 2807
     */
    public void onClick(View v){
        if(v.equals(b1)){
            Intent i1 = new Intent(this, BolitaJava.class);
            startActivity(i1);
        }
        if(v.equals(b2)){
            Intent i1 = new Intent(this, BolitaImagen.class);
            startActivity(i1);
        }
        if(v.equals(b3)){
            Intent i1 = new Intent(this, BolitaImagenAnimada.class);
            startActivity(i1);
        }
    }
}
