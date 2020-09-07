package com.example.miformulario;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText Descripcion;
    EditText Email;
    EditText Telefono;
    EditText Nombre;
    ImageButton imgFecha;
    EditText Fecha;
    DatePickerDialog.OnDateSetListener setListener;
    Button Confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Descripcion = findViewById(R.id.Descripcion);
        Email = findViewById(R.id.Email);
        Telefono = findViewById(R.id.Telefono);
        Nombre = findViewById(R.id.Nombre);
        Confirmar = findViewById(R.id.Confirmar);
        imgFecha = findViewById(R.id.imgFecha);
        Fecha = findViewById(R.id.Fecha);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        imgFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                Fecha.setText(date);

            }
        };

        Confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ConfirmarDatos.class);
                intent.putExtra("Nombre",Nombre.getText().toString());
                intent.putExtra("Fecha",Fecha.getText().toString());
                intent.putExtra("Telefono",Telefono.getText().toString());
                intent.putExtra("Email",Email.getText().toString());
                intent.putExtra("Descripcion",Descripcion.getText().toString());
                startActivity(intent);
            }
        });







    }
}