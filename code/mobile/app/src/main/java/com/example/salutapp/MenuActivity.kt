package com.example.salutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var iv_power: ImageView = findViewById(R.id.iv_power);
        var iv_settings:ImageView = findViewById(R.id.iv_settings)
        var cd_emergence: androidx.cardview.widget.CardView = findViewById(R.id.cd_emergence);
        var cd_historico: androidx.cardview.widget.CardView = findViewById(R.id.cd_historico);

        iv_power.setOnClickListener {
            turnOff()
        }

        cd_emergence.setOnClickListener {
            enterEmergence()
        }

        cd_historico.setOnClickListener {
            enterHistorico()
        }

        iv_settings.setOnClickListener {
            enterSettings()
        }
    }

    private fun turnOff() {
        finishAffinity()
    }

    private fun enterEmergence() {
        val intent = Intent(this, InteractiveDollActivity::class.java)
        startActivity(intent)
    }

    private fun enterHistorico() {
        val intent = Intent(this, HistoricoMedico::class.java)
        startActivity(intent)
    }

    private fun enterSettings() {
        val intent = Intent(this, ConfiguracaoActivity::class.java)
        startActivity(intent)
    }
}