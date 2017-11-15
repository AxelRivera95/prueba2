package com.example.axeelz.pruebaaa;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListadoPropiedad extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_propiedad);
       cargar();

    }
public void cargar()
{
    BaseHelper helper = new BaseHelper(this,"PROPIEDAD",null,1);
    SQLiteDatabase db = helper.getReadableDatabase();
    if(db!=null){
        Cursor c= db.rawQuery("select * from PROPIEDAD",null);
        int cantidad = c.getCount();
        int i=0;
        String []arreglo = new String[cantidad];
        if(c.moveToFirst()){
            do{
                String linea = c.getString(0)+ " "+c.getString(1)+" "+ c.getString(2)+" "+c.getString(3)+" "+c.getString(4)+" "+c.getString(5)+" "+c.getString(6)+" "+c.getString(7)+" "+c.getString(8);
                arreglo[i]=linea;
                i++;
            }while (c.moveToNext());
        }

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
        ListView lista= (ListView)findViewById(R.id.listView);
        lista.setAdapter(adapter);
    }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
