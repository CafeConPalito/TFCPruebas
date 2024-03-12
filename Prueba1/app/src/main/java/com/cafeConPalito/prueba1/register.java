package com.cafeConPalito.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class register extends AppCompatActivity {

    TextView tvreg1,tvreg2,tvreg3,tvreg4;
    EditText etPassword, etNombre, etEmail;
    AdminSQLiteOpenHelper admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etPassword = findViewById(R.id.etPassword);
        etEmail= findViewById(R.id.etEmail);
        etNombre= findViewById(R.id.etNombre);
        tvreg1= findViewById(R.id.tvreg1);
        tvreg2= findViewById(R.id.tvreg2);
        tvreg3= findViewById(R.id.tvreg3);
        tvreg4= findViewById(R.id.tvreg4);
        admin=new AdminSQLiteOpenHelper(this,"bd1", null,1);    }

    public void guardar(View v){
        if (etNombre.getText().toString().isEmpty()){
            tvreg2.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            tvreg2.setText("introduce un nombre válido");
        }
        if (etEmail.getText().toString().isEmpty()){
            tvreg3.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            tvreg3.setText("introduce un email válido");
        }
        if (etPassword.getText().toString().isEmpty()){
            tvreg4.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            tvreg4.setText("introduce un password válido");
        }

/*
        SQLiteDatabase  bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("email", etEmail.getText().toString());
        registro.put("nombre", etNombre.getText().toString());
        registro.put("password", etPassword.getText().toString());
        bd.insert("usuario",null, registro);
        bd.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);*/
    }

}