package com.example.programa01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/*
ALUMNO: MERCADO ROMERO YAHIR RICARDO
PROGRAMACIÓN MOVÍL, GRUPO: 2807
 */
public class MainActivity extends Activity {

    EditText et1, et2;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mivista);

        et1 = (EditText) findViewById(R.id.numuno);
        et2 = (EditText) findViewById(R.id.numdos);
        res = (TextView) findViewById(R.id.resultado);
    }

    public void metodosumar(View v) {
        try {
            int num1 = Integer.parseInt(et1.getText().toString().trim());
            int num2 = Integer.parseInt(et2.getText().toString().trim());
            int resultado = num1 + num2;

            res.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingresa números válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
