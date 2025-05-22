package com.example.proyecto;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    View luzRoja, luzAmarilla, luzVerde;
    Button botonRojo, botonAmarillo, botonVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        luzRoja = findViewById(R.id.luz_roja);
        luzAmarilla = findViewById(R.id.luz_amarilla);
        luzVerde = findViewById(R.id.luz_verde);

        botonRojo = findViewById(R.id.btnrojo);
        botonAmarillo = findViewById(R.id.btnamarillo);
        botonVerde = findViewById(R.id.btnverde);

        botonRojo.setOnClickListener(view -> {
            apagarLuces();
            luzRoja.setBackgroundColor(Color.RED);
        });

        botonAmarillo.setOnClickListener(view -> {
            apagarLuces();
            luzAmarilla.setBackgroundColor(Color.YELLOW);
        });

        botonVerde.setOnClickListener(view -> {
            apagarLuces();
            luzVerde.setBackgroundColor(Color.GREEN);
        });
    }

    private void apagarLuces() {
        luzRoja.setBackgroundColor(Color.parseColor("#55000000"));
        luzAmarilla.setBackgroundColor(Color.parseColor("#55000000"));
        luzVerde.setBackgroundColor(Color.parseColor("#55000000"));
    }
}
