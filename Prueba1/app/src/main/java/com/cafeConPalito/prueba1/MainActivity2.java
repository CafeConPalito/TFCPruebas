package com.cafeConPalito.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv4;
    private Button button;

    private ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        iv2 = findViewById(R.id.iv2);
        iv2.setImageResource(R.drawable.logo);

        tv4= findViewById(R.id.tv4);

        Bundle recibedatos = getIntent().getExtras();
        String nombre = recibedatos.getString("nombre");

        tv4.setText("Bienvenido, " + nombre);

    }
    private void salir(View v){
        finish();
    }

}