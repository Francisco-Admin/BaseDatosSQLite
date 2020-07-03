package com.edu.isc.tesoem.francisco.basedatossqlite.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.net.PortUnreachableException;
import java.security.PublicKey;

public class DatosHelper  extends SQLiteOpenHelper {

    private static DatosHelper datosHelper = null;
    private static String NOMBRE = "bdAgenda";
    private static  int VERSION_BD=1;

    public DatosHelper(@Nullable Context context) {
        super(context,NOMBRE,null, VERSION_BD);
    }

    public  static class tabladatos{
        public static  String TABLA = "tbDatos";
        public static String COLUMNA_ID="ID";
        public static String COLUMNA_NOMBRE="nombre";
        public static String COLUMNA_EDAD = "edad";
        public static String COLUMNA_SEXO = "sexo";
    }

        public static final String CONSULTA_CREAR_TABLA="create table " +
                tabladatos.TABLA + "(" + tabladatos.COLUMNA_ID + " integer not null primary key autoincrement, " +
                tabladatos.COLUMNA_NOMBRE + " varchar," + tabladatos.COLUMNA_EDAD + "varchar," + tabladatos.COLUMNA_SEXO + " varchar); ";

    public static final String CONSULTAR_ELIMINAR_TABLA = "drop table if exists " +  tabladatos.TABLA;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONSULTA_CREAR_TABLA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        bd.execSQL(CONSULTAR_ELIMINAR_TABLA);
        onCreate(bd);
    }
}
