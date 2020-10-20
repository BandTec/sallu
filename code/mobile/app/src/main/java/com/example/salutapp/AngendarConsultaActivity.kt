package com.example.salutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner

class AngendarConsultaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angendar_consulta)

        var spinner1: Spinner = findViewById(R.id.spinner1);
        var spinner2: Spinner = findViewById(R.id.spinner2);
        var spinner3: Spinner = findViewById(R.id.spinner3);

       var medicos = arrayOf("Pediatra" , "Cardiologista", "Dermatologista", "Clinico Geral");
       var locais = arrayOf("Osasco", "Itapevi", "São Paulo");
       var doencas = arrayOf("Gripe", "COVID-19");


    }
}