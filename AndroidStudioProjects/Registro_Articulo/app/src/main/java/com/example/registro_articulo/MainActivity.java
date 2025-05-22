package com.example.registro_articulo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     /*
         ALUMNO: MERCADO ROMERO YAHIR RICARDO
         PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    private EditText et1, et2, et3;
    private Button btnAlta, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btnAlta = findViewById(R.id.btnAlta);
        btnRegresar = findViewById(R.id.btnRegresar);

        btnAlta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alta();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarUltimoRegistro();
            }
        });
    }

    /*
         ALUMNO: MERCADO ROMERO YAHIR RICARDO
         PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    public void alta() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd = admin.getWritableDatabase();

        try {
            ContentValues registro = new ContentValues();
            registro.put("codigo", Integer.parseInt(et1.getText().toString()));
            registro.put("descripcion", et2.getText().toString());
            registro.put("precio", Double.parseDouble(et3.getText().toString()));

            bd.insert("articulos", null, registro);
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

            et1.setText("");
            et2.setText("");
            et3.setText("");
        } catch (Exception e) {
            Toast.makeText(this, "Error al guardar: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            bd.close();
        }
    }

     /*
         ALUMNO: MERCADO ROMERO YAHIR RICARDO
         PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    public void mostrarUltimoRegistro() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd = admin.getReadableDatabase();

        Cursor cursor = bd.rawQuery("SELECT codigo, descripcion, precio FROM articulos ORDER BY codigo DESC LIMIT 1", null);

        if (cursor.moveToFirst()) {
            et1.setText(String.valueOf(cursor.getInt(0)));
            et2.setText(cursor.getString(1));
            et3.setText(String.valueOf(cursor.getDouble(2)));
            Toast.makeText(this, "Último registro mostrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No hay registros para mostrar", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        bd.close();
    }
}
