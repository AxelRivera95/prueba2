package com.example.axeelz.pruebaaa;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarPropiedad extends AppCompatActivity {
EditText et_id,et_cliente,et_categoria,et_tipo,et_precio,et_direccion,et_ciudad,et_comuna,et_estado;
    Button btn_guardar,btn_listar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_propiedad);

        et_id=(EditText)findViewById(R.id.et_id);
        et_cliente=(EditText)findViewById(R.id.et_cliente);
        et_categoria=(EditText)findViewById(R.id.et_categoria);
        et_tipo=(EditText)findViewById(R.id.et_tipo);
        et_precio=(EditText)findViewById(R.id.et_precio);
        et_direccion=(EditText)findViewById(R.id.et_direccion);
        et_ciudad=(EditText)findViewById(R.id.et_ciudad);
        et_comuna=(EditText)findViewById(R.id.et_comuna);
        et_estado=(EditText)findViewById(R.id.et_estado);






    }
   public void GuardarDatos (View view)
    {

        String id=et_id.getText().toString();
        String cliente=et_cliente.getText().toString();
        String categoria=et_categoria.getText().toString();
        String tipo=et_tipo.getText().toString();
        String precio=et_precio.getText().toString();
        String direccion=et_direccion.getText().toString();
        String ciudad=et_ciudad.getText().toString();
        String comuna=et_comuna.getText().toString();
        String estado=et_estado.getText().toString();

        BaseHelper helper = new BaseHelper(this,"PROPIEDAD",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();

        if(db!=null){
            ContentValues c= new ContentValues();

            c.put("Id",id);
            c.put("Cliente",cliente);
            c.put("Categoria",categoria);
            c.put("Tipo",tipo);
            c.put("Precio", precio);
            c.put("Direccion",direccion);
            c.put("Ciudad",ciudad);
            c.put("Comuna",comuna);
            c.put("Estado",estado);
           long i= db.insert("PROPIEDAD",null,c);
            if(i>0){
                Toast.makeText(this, "PROPIEDAD INSERTADA",Toast.LENGTH_SHORT).show();
            }


        }



    }
}

