package com.example.registro_articulo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    /*
         ALUMNO: MERCADO ROMERO YAHIR RICARDO
         PROGRAMACIÓN MOVÍL, GRUPO: 2807
     */

    private static final String DATABASE_NAME = "administracion.db";
    private static final int DATABASE_VERSION = 1;

    public AdminSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE articulos (codigo INTEGER PRIMARY KEY, descripcion TEXT, precio REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS articulos");
        onCreate(db);
    }
}
