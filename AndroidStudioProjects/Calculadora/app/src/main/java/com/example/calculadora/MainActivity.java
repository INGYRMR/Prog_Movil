package com.example.calculadora;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
   ALUMNO: MERCADO ROMERO YAHIR RICARDO
   PROGRAMACIÓN MOVÍL, GRUPO: 2807
 */

public class MainActivity extends Activity {

    private EditText pantalla;
    private String entradaActual = "";
    private String operador = "";
    private double primerNumero = 0;
    private boolean operadorClickeado = false;
    private boolean puntoClickeado = false;

    int botonesNumericos[] = {
            R.id.button0,
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9
    };

    Button[] botones = new Button[10];

    /*
       ALUMNO: MERCADO ROMERO YAHIR RICARDO
       PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        pantalla = findViewById(R.id.pantalla);
        pantalla.setTextColor(Color.parseColor("#FF0000"));
        pantalla.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        View.OnClickListener listenerBotonNumerico = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boton = (Button) v;
                entradaActual += boton.getText().toString();
                pantalla.setText(entradaActual);
            }
        };

        for (int i = 0; i <= 9; i++) {
            botones[i] = findViewById(botonesNumericos[i]);
            botones[i].setOnClickListener(listenerBotonNumerico);
        }

        // Operaciones
        findViewById(R.id.buttonSuma).setOnClickListener(v -> guardarOperacion("+"));
        findViewById(R.id.buttonResta).setOnClickListener(v -> guardarOperacion("-"));
        findViewById(R.id.buttonMultiplicacion).setOnClickListener(v -> guardarOperacion("*"));
        findViewById(R.id.buttonDivision).setOnClickListener(v -> guardarOperacion("/"));
        findViewById(R.id.buttonIgual).setOnClickListener(this::metodoigual);

        // Punto decimal

        /*
       ALUMNO: MERCADO ROMERO YAHIR RICARDO
       PROGRAMACIÓN MOVÍL, GRUPO: 2807
       */

        findViewById(R.id.buttonPunto).setOnClickListener(v -> {
            if (!puntoClickeado) {
                if (entradaActual.isEmpty()) {
                    entradaActual = "0.";
                } else {
                    entradaActual += ".";
                }
                pantalla.setText(entradaActual);
                puntoClickeado = true;
            }
        });

        // Botón C (limpiar)
        findViewById(R.id.buttonClear).setOnClickListener(v -> {
            entradaActual = "";
            operador = "";
            primerNumero = 0;
            operadorClickeado = false;
            puntoClickeado = false;
            pantalla.setText("");
        });
    }

    private void guardarOperacion(String op) {
        try {
            primerNumero = Double.parseDouble(pantalla.getText().toString());
            entradaActual = "";
            pantalla.setText("");
            operador = op;
            operadorClickeado = true;
            puntoClickeado = false;
        } catch (NumberFormatException e) {
            pantalla.setText("Error");
        }
    }
      /*
       ALUMNO: MERCADO ROMERO YAHIR RICARDO
       PROGRAMACIÓN MOVÍL, GRUPO: 2807
       */

    public void metodoigual(View view) {
        try {
            double segundoNumero = Double.parseDouble(pantalla.getText().toString());
            double resultado = 0;

            switch (operador) {
                case "+": resultado = primerNumero + segundoNumero; break;
                case "-": resultado = primerNumero - segundoNumero; break;
                case "*": resultado = primerNumero * segundoNumero; break;
                case "/":
                    if (segundoNumero != 0) {
                        resultado = primerNumero / segundoNumero;
                    } else {
                        pantalla.setText("Error: ÷0");
                        return;
                    }
                    break;
                default:
                    pantalla.setText("Error");
                    return;
            }

            pantalla.setText(String.valueOf(resultado));
            entradaActual = String.valueOf(resultado);
            operador = "";
            operadorClickeado = false;
            puntoClickeado = entradaActual.contains(".");
        } catch (NumberFormatException e) {
            pantalla.setText("Error");
        }
    }
}
