package com.example.abraham.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoActivity extends AppCompatActivity {

    Button btnNuevo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        btnNuevo = (Button) findViewById(R.id.guardar);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nombre= (EditText) findViewById(R.id.nombre);
                EditText tel= (EditText) findViewById(R.id.tel);
                EditText cel= (EditText) findViewById(R.id.cel);
                EditText correo= (EditText) findViewById(R.id.correo);
                Intent i = new Intent (NuevoActivity.this, MainActivity.class);
                i.putExtra("nombre", nombre.getText()+"");
                i.putExtra("tel", tel.getText()+"");
                i.putExtra("cel", cel.getText()+"");
                i.putExtra("correo", correo.getText()+"");
                startActivity(i);

            }
        });

    }

}
