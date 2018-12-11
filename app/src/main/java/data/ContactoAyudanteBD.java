package data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactoAyudanteBD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION= 2;
    public static final String DATABASE_NAME="Contactos1.db";

    public ContactoAyudanteBD(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ ContactoContract.ContactoEntry.TABLE_NAME
                +"("+ ContactoContract.ContactoEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ContactoContract.ContactoEntry.ID+" TEXT NOT NULL,"
                + ContactoContract.ContactoEntry.NOMBRE+" TEXT NOT NULL,"
                + ContactoContract.ContactoEntry.TELEFONO+" TEXT NOT NULL,"
                + ContactoContract.ContactoEntry.CELULAR+" TEXT ,"
                + ContactoContract.ContactoEntry.CORREO+" TEXT NOT NULL,"
                + " UNIQUE ("+ ContactoContract.ContactoEntry.ID +"))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long newContacto(SQLiteDatabase db, contacto contacto) {
        return db.insert(
                ContactoContract.ContactoEntry.TABLE_NAME,
                null,
                contacto.toContentValues());
    }

    public Cursor getByID(SQLiteDatabase db, String contactoID){
        Cursor c = db.query(ContactoContract.ContactoEntry.TABLE_NAME,
                null,
                ContactoContract.ContactoEntry.ID+" LIKE ?",
                new String[]{contactoID},
                null,
                null,
                null);
        return c;
    }

}
