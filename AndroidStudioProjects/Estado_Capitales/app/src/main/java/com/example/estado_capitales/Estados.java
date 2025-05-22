package com.example.estado_capitales;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Estados extends Activity {

    /*
        ALUMNO: MERCADO ROMERO YAHIR RICARDO
        PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    private Spinner stateSpinner;
    private TextView capitalTextView;


    private Map<String, String> stateCapitalMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados);

        stateSpinner = findViewById(R.id.stateSpinner);
        capitalTextView = findViewById(R.id.capitalTextView);

        // Initialize the map of states and capitals
        stateCapitalMap = new HashMap<>();
        stateCapitalMap.put("España", "Madrid");
        stateCapitalMap.put("Rusia", "Moscú");
        stateCapitalMap.put("Suiza", "Berna");

        // Create an array of state names
        String[] states = stateCapitalMap.keySet().toArray(new String[0]);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        stateSpinner.setAdapter(adapter);

         /*
            ALUMNO: MERCADO ROMERO YAHIR RICARDO
            PROGRAMACIÓN MOVÍL, GRUPO: 2807
         */

        // Set an item selected listener for the spinner
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = parent.getItemAtPosition(position).toString();
                String capital = stateCapitalMap.get(selectedState);
                capitalTextView.setText("Capital: " + capital);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                capitalTextView.setText("");
            }
        });
    }
    public void regresarPrincipal(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
