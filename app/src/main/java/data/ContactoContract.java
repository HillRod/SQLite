package data;

import android.provider.BaseColumns;

public class ContactoContract {
    public static abstract class ContactoEntry implements
            BaseColumns{
        public static final String TABLE_NAME = "contacto",
        ID = "id",
        NOMBRE ="nombre",
        TELEFONO="telefono",
        CELULAR="celular",
        CORREO="correo";
    }
}
