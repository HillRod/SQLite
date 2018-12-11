package com.example.abraham.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    Button btnModificar;
    Button btnInicio;
    Button btnBorrar;
    String id;
    TextView nombre;
    TextView tel;
    TextView cel;
    TextView correo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        nombre= (TextView) findViewById(R.id.nombre);
        tel= (TextView) findViewById(R.id.tel);
        cel= (TextView) findViewById(R.id.cel);
        correo= (TextView) findViewById(R.id.correo);
        ///Setean los valores al layout con los datos obtenidos del intent
        id=getIntent().getStringExtra("id");
        nombre.setText(getIntent().getStringExtra("nombre"));
        tel.setText(getIntent().getStringExtra("tel"));
        cel.setText(getIntent().getStringExtra("cel"));
        correo.setText(getIntent().getStringExtra("correo"));


    }


}
