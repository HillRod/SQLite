package data;

import android.content.ContentValues;

import java.util.UUID;

public class contacto {
    private String id,nombre,telefono,celular,correo;

    public contacto(String nombre, String telefono,
                    String celular, String correo){
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
    }

    public contacto(String id,String nombre, String telefono,
                    String celular, String correo){
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ContactoContract.ContactoEntry.ID, id);
        values.put(ContactoContract.ContactoEntry.NOMBRE, nombre);
        values.put(ContactoContract.ContactoEntry.TELEFONO, telefono);
        values.put(ContactoContract.ContactoEntry.CELULAR, celular);
        values.put(ContactoContract.ContactoEntry.CORREO, correo);
        return values;
    }

}
