package com.example.abraham.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import data.contacto;

public class Adapter extends BaseAdapter{
    Context context;
    List<contacto> Contactos;

    public Adapter(Context c,List<contacto> Listo){
        this.context = c;
        this.Contactos = Listo;
    }

    @Override
    public int getCount() {
        return Contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return Contactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(context);
        vista = inflate.inflate(R.layout.contacto,null);
        TextView nombre = (TextView)vista.findViewById(R.id.nombre);
        nombre.setText(Contactos.get(position).getNombre().toString());
        return vista;
    }
}
