package com.edu.isc.tesoem.francisco.basedatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.isc.tesoem.francisco.basedatossqlite.BaseDatos.DatosConexion;

public class RegistroActivity extends AppCompatActivity {

    EditText txtnombre, txtedad, txtsexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtsexo = findViewById(R.id.txtsexo);
    }

    public void registra_registro(View v) {
        ContentValues contentValues = new ContentValues();
        DatosConexion datosConexion = new DatosConexion(this);
        datosConexion.open();

        contentValues.put("nombre", txtnombre.getText().toString());
        contentValues.put("edad", txtedad.getText().toString());
        contentValues.put("sexo", txtsexo.getText().toString());

        if (datosConexion.insertar(contentValues)) {
            Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "No se pudo grabar.....", Toast.LENGTH_SHORT).show();
        }
        datosConexion.close();

    }
}