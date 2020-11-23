package com.example.salutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InteractiveDollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interactive_doll)

        var btnMapa: Button = findViewById(R.id.btnMapa);

        btnMapa.setOnClickListener {
            enterMapa()
        }
    }

    private fun enterMapa() {
        val intent = Intent(this,FindLocationMapsActivity::class.java)
        startActivity(intent);
    }
}