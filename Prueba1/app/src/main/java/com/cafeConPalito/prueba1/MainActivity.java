package com.cafeConPalito.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv3;
    private EditText edt1,edtEmail;
    private ImageView iv1;

    private Button entrar;
    private Button registrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edtEmail=findViewById(R.id.edtEmail);

        iv1=findViewById(R.id.iv1);
        iv1.setImageResource(R.drawable.logo);
        entrar= findViewById(R.id.entrar);
        registrar= findViewById(R.id.registrar);



        entrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                // en el tutorial que sigo no crea el bundle aquí, directamente hace el putExtra que comento en el siguiente apartado
                Bundle enviaDatos = new Bundle();
                enviaDatos.putString("nombre", edt1.getText().toString());

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //intent.putExtra("nombre", nombre); (crea un bundle en la siguiente actividad para recibir el dato, pero aquí no)
                intent.putExtras(enviaDatos);
                startActivity(intent);
            }


        });

    }
    public void registrar(View v){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }



}