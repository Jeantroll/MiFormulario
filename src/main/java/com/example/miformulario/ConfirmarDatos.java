package com.example.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    Button btnEditar;
    TextView Persona;
    TextView Nacimiento;
    TextView Celular;
    TextView Correo;
    TextView Parrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btnEditar = findViewById(R.id.btnEditar);
        Persona = findViewById(R.id.Persona);
        Nacimiento = findViewById(R.id.Nacimiento);
        Celular = findViewById(R.id.Celular);
        Correo = findViewById(R.id.Correo);
        Parrafo = findViewById(R.id.Parrafo);


        Intent intent = getIntent();

        Persona.setText(intent.getStringExtra("Nombre"));
        Nacimiento.setText(intent.getStringExtra("Fecha"));
        Celular.setText(intent.getStringExtra("Telefono"));
        Correo.setText(intent.getStringExtra("Email"));
        Parrafo.setText(intent.getStringExtra("Descripcion"));


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();


            }
        });
    }
}