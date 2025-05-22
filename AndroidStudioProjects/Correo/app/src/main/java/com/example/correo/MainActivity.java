package com.example.correo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
         ALUMNO: MERCADO ROMERO YAHIR RICARDO
         PROGRAMACIÓN MOVÍL, GRUPO: 2807
    */

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
    }

    public void guardar(View v) {
        SharedPreferences preferencias = getSharedPreferences("datos", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("mail", et1.getText().toString());
        editor.apply();
        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
    }

    public void recuperar(View v) {
        SharedPreferences preferencias = getSharedPreferences("datos", MODE_PRIVATE);
        String d = preferencias.getString("mail", "");
        et1.setText(d);
    }
}
