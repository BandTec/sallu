package com.example.salutapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class InteractiveDollActivity : AppCompatActivity() {

    val list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interactive_doll)

        setSingleEvent();

        val btnMapa : Button = findViewById(R.id.btnMapa);

        btnMapa.setOnClickListener {
            enterMapa();
        }
    }

     fun setSingleEvent() {
         findViewById<CardView>(R.id.cd_head).setOnClickListener {

             if(list.find { it == "Dor de Cabeça" } == null) list.add("Dor de Cabeça") else
                 list.remove("Dor de Cabeça")
         }

         findViewById<CardView>(R.id.cd_eye).setOnClickListener {
             if(list.find { it == "Dores na Vista" } == null) list.add("Dores na Vista") else
                 list.remove("Dores na Vista")
         }

         findViewById<CardView>(R.id.cd_kindey).setOnClickListener {
             if(list.find { it == "Dores nos Rins" } == null) list.add("Dores nos Rins") else
                 list.remove("Dores nos Rins")
         }

         findViewById<CardView>(R.id.cd_liver).setOnClickListener {
             if(list.find { it == "Dor no Fígado" } == null) list.add("Dor no Fígado") else
                 list.remove("Dor no Fígado")
         }

         findViewById<CardView>(R.id.cd_lung).setOnClickListener {
             if(list.find { it == "Dores no Pulmão" } == null) list.add("Dores no Pulmão") else
                 list.remove("Dores no Pulmão")
         }

         findViewById<CardView>(R.id.cd_heart).setOnClickListener {
             if(list.find { it == "Dores Cardíacas" } == null) list.add("Dores Cardíacas") else
                 list.remove("Dores Cardíacas")
         }

         findViewById<CardView>(R.id.cd_bones).setOnClickListener {
             if(list.find { it == "Dor nos Ossos" } == null) list.add("Dor nos Ossos") else
                 list.remove("Dor nos Ossos")
         }

         findViewById<CardView>(R.id.cd_veins).setOnClickListener {
             if(list.find { it == "Problemas nas Veias" } == null) list.add("Problemas nas Veias") else
                 list.remove("Problemas nas Veias")
         }
     }

    private fun enterMapa() {
        val intent = Intent(this, FindLocationMapsActivity::class.java)
        intent.putExtra("agora vai", list.toString())
        startActivity(intent);
    }
}
