package com.example.salutapp
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.salutapp.api.model.Login
import kotlinx.android.synthetic.main.activity_marca_consulta.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var nomeUsuario= intent.extras?.getString("nome")
        user_name.text=nomeUsuario
        println(nomeUsuario)

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
            var id = intent.extras?.getString("id")
            var usuario = intent.extras?.getString("nome")
            val telaConfig = Intent(this@MenuActivity, ConfiguracaoActivity::class.java)
            telaConfig.putExtra("id",id)
            telaConfig.putExtra("nome",usuario)
            startActivity(telaConfig)
        }
    }

    private fun nextEmergence() {
        val intent = Intent(this,InteractiveDollActivity::class.java)
        startActivity(intent);
    }

    private fun nextFicha() {
        var genero = intent.extras?.getString("genero")
        val telaFicha = Intent(this@MenuActivity, FichaMedica::class.java)
        telaFicha.putExtra("genero", genero)
        startActivity(telaFicha)
    }

    private fun nextMarca() {
        val intent = Intent(this, MarcaConsultaActivity::class.java)
        startActivity(intent);
    }

    private fun nextHistorico() {
        var id = intent.extras?.getString("id")
        val telaHistorico = Intent(this@MenuActivity, HistoricoMedico::class.java)
        telaHistorico.putExtra("id", id)
        startActivity(telaHistorico)
    }

    private fun turnOff() {
        var preferencias = getSharedPreferences("Autenticacao",Context.MODE_PRIVATE)
        preferencias.edit().remove("nome").commit()
        preferencias.edit().remove("id").commit()
        val telaLogin = Intent(this@MenuActivity, LoginActivity::class.java)
        startActivity(telaLogin)
    }
}