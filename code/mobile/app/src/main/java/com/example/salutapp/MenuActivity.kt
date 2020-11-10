package com.example.salutapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var logout: ImageView = findViewById(R.id.iv_power);
        var telaPerfil:ImageView = findViewById(R.id.iv_settings)
        var telaEmergencia: androidx.cardview.widget.CardView = findViewById(R.id.cd_emergence);
        var telaFichaMedica: androidx.cardview.widget.CardView = findViewById(R.id.cd_fichaMedica);
        var telaAgendarConsulta: androidx.cardview.widget.CardView = findViewById(R.id.cd_agendar_consulta);
        var telaHistorico: androidx.cardview.widget.CardView = findViewById(R.id.cd_historico);

        logout.setOnClickListener {
            turnOff()
        }

        telaPerfil.setOnClickListener {
            irTelaPerfil()
        }

        telaEmergencia.setOnClickListener {
            irTelaEmergencia()
        }

        telaFichaMedica.setOnClickListener{
            irTelaFichaMedica()
        }

        telaAgendarConsulta.setOnClickListener{
            irTelaAgendarConsulta()
        }

        telaHistorico.setOnClickListener {
            irTelaHistorico()
        }
    }

    private fun turnOff() {
        finishAffinity()
    }

    private fun irTelaPerfil() {
        val intent = Intent(this, ConfiguracaoActivity::class.java)
        startActivity(intent)
    }

    private fun irTelaEmergencia() {
        val intent = Intent(this, InteractiveDollActivity::class.java)
        startActivity(intent)
    }

    fun irTelaFichaMedica(){
        val intent = Intent(this, FichaMedica::class.java)
        startActivity(intent)
    }

    fun irTelaAgendarConsulta(){
        val intent = Intent(this, MarcaConsultaActivity::class.java)
        startActivity(intent)
    }

    private fun irTelaHistorico() {
        val intent = Intent(this, HistoricoMedico::class.java)
        startActivity(intent)
    }
}