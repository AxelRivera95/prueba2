package com.example.axeelz.pruebaaa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by AxeelZ on 14-11-2017.
 */

public class BaseHelper extends SQLiteOpenHelper {

    String tabla="CREATE TABLE PROPIEDAD(ID TEXT PRIMARY KEY," +
            " CLIENTE TEXT," +
            " CATEGORIA TEXT," +
            " TIPO TEXT," +
            " PRECIO TEXT," +
            " DIRECCION TEXT, " +
            " CIUDAD TEXT, " +
            " COMUNA TEXT,"+
            " ESTADO TEXT)";
    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table PROPIEDAD");
        db.execSQL(tabla);
    }
}
