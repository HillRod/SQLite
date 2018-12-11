package com.example.abraham.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

import data.ContactoAyudanteBD;
import data.ContactoContract;
import data.contacto;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    List<contacto> Lista;
    Adapter miadapter;
    ContactoAyudanteBD ayudante;
    SQLiteDatabase bd;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lista = new ArrayList<contacto>();
        lista = (ListView) findViewById(R.id.list);
        ayudante = new ContactoAyudanteBD(this);
        bd = ayudante.getWritableDatabase();
        add = (Button)findViewById(R.id.agregar);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),NuevoActivity.class));
            }
        });


        //Obtiene los datos del intent anterior
        String id = getIntent().getStringExtra("id");
        String nombre = getIntent().getStringExtra("nombre");
        String tel = getIntent().getStringExtra("tel");
        String cel = getIntent().getStringExtra("cel");
        //Toast.makeText(this,cel,Toast.LENGTH_SHORT).show();
        String correo = getIntent().getStringExtra("correo");
        String idDelete=getIntent().getStringExtra("idDelete");

        if(id==null&&nombre!=null)
        {
            ayudante.newContacto(bd,new contacto(nombre,tel,cel,correo));
        }

        consulta();

        miadapter = new Adapter(getApplicationContext(),Lista);
        lista.setAdapter(miadapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contacto item = (contacto) miadapter.getItem(position);
                Intent i = new Intent(MainActivity.this,DetalleActivity.class);
                Cursor consultaID = ayudante.getByID(bd,item.getId());
                if (consultaID.moveToFirst()&& consultaID.getCount()==1) {
                    i.putExtra("id",consultaID.getString(1));
                    i.putExtra("nombre",consultaID.getString(2));
                    i.putExtra("tel",consultaID.getString(3));
                    i.putExtra("cel",consultaID.getString(4));
                    i.putExtra("correo",consultaID.getString(5));
                }
                startActivity(i);
            }
        });
    }



    public void consulta() {
        Cursor consulta = bd.query(
                ContactoContract.ContactoEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);


        if (consulta.moveToFirst()&& consulta.getCount()>0) {
            Toast.makeText(this, ""+consulta.getCount(), Toast.LENGTH_SHORT).show();
            Lista.add(new contacto(consulta.getString(1),consulta.getString(2),consulta.getString(3),consulta.getString(4),consulta.getString(5)));
            while(consulta.moveToNext())
            {
                Lista.add(new contacto(consulta.getString(1),consulta.getString(2),consulta.getString(3),consulta.getString(4),consulta.getString(5)));
            }

        }
    }


}
