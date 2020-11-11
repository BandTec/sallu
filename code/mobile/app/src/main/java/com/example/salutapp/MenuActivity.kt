package com.example.salutapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_marca_consulta.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var cd_emergence: androidx.cardview.widget.CardView = findViewById(R.id.cd_emergence);
        var cd_ficha_medica: androidx.cardview.widget.CardView = findViewById(R.id.cd_ficha_medica_menu);
        var cd_marca_consulta: androidx.cardview.widget.CardView = findViewById(R.id.cd_marca_consulta);
        var cd_historico: androidx.cardview.widget.CardView = findViewById(R.id.cd_historico);

        var iv_power: ImageView = findViewById(R.id.iv_power);
        var iv_settings: ImageView = findViewById(R.id.iv_settings);

        cd_emergence.setOnClickListener {
            nextEmergence();
        }

        cd_ficha_medica.setOnClickListener {
            nextMarca();
        }

        cd_marca_consulta.setOnClickListener {
            nextFicha();
        }

        cd_historico.setOnClickListener {
            nextHistorico();
        }

        iv_power.setOnClickListener {
            turnOff();
        }

        iv_settings.setOnClickListener {
            nextSettings();
        }
    }
    private fun nextEmergence() {
        val intent = Intent(this,InteractiveDollActivity::class.java)
        startActivity(intent);
    }

    private fun nextFicha() {
        val intent = Intent(this, FichaMedica::class.java)
        startActivity(intent);
    }

    private fun nextMarca() {
        val intent = Intent(this, MarcaConsultaActivity::class.java)
        startActivity(intent);
    }

    private fun nextHistorico() {
        val intent = Intent(this, HistoricoMedico::class.java)
        startActivity(intent);
    }

    private fun turnOff() {
        finishAffinity();
    }

    private fun nextSettings() {
        val intent = Intent(this, ConfiguracaoActivity::class.java)
        startActivity(intent);
    }
}