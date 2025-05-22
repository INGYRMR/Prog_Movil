package com.example.proyecto2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Tarea> listaTareas = new ArrayList<>();
    private AdaptadorTarea adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText entradaTarea = findViewById(R.id.entrada_tarea);
        Button botonAgregar = findViewById(R.id.boton_agregar);
        RecyclerView listaRecycler = findViewById(R.id.lista_tareas);

        adaptador = new AdaptadorTarea(listaTareas);
        listaRecycler.setLayoutManager(new LinearLayoutManager(this));
        listaRecycler.setAdapter(adaptador);

        botonAgregar.setOnClickListener(v -> {
            String texto = entradaTarea.getText().toString();
            if (!texto.isEmpty()) {
                listaTareas.add(new Tarea(texto));
                adaptador.notifyItemInserted(listaTareas.size() - 1);
                entradaTarea.setText("");
            }
        });
    }
}
