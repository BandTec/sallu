package com.example.salutapp
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.salutapp.api.model.Login
import kotlinx.android.synthetic.main.activity_marca_consulta.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    var preferencias: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        trazerNome()

        var cd_emergence: androidx.cardview.widget.CardView = findViewById(R.id.cd_emergence);
        var cd_ficha_medica: androidx.cardview.widget.CardView = findViewById(R.id.cd_ficha_medica_menu);
        var cd_marca_consulta: androidx.cardview.widget.CardView = findViewById(R.id.cd_marca_consulta);
        var cd_historico: androidx.cardview.widget.CardView = findViewById(R.id.cd_historico)
        var cd_maps: androidx.cardview.widget.CardView = findViewById(R.id.cd_maps)

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

        cd_maps.setOnClickListener {
            goToMaps();
        }

        iv_power.setOnClickListener {
            turnOff();
        }

        iv_settings.setOnClickListener {
            val telaConfig = Intent(this@MenuActivity, ConfiguracaoActivity::class.java)
            startActivity(telaConfig)
        }
    }

    private fun nextEmergence() {
        val intent = Intent(this, InteractiveDollActivity::class.java)
        startActivity(intent);
    }

    private fun nextFicha() {
        val telaFicha = Intent(this@MenuActivity, FichaMedica::class.java)
        startActivity(telaFicha)
    }

    private fun nextMarca() {
        val intent = Intent(this, MarcaConsultaActivity::class.java)
        startActivity(intent);
    }

    private fun nextHistorico() {
        val telaHistorico = Intent(this@MenuActivity, HistoricoMedico::class.java)
        startActivity(telaHistorico)
    }

    private fun turnOff() {
        var preferencias = getSharedPreferences("Autenticacao",Context.MODE_PRIVATE)
        preferencias.edit().remove("nome").commit()
        preferencias.edit().remove("genero").commit()
        preferencias.edit().remove("token").commit()
        preferencias.edit().remove("id").commit()
        preferencias.edit().remove("email").commit()
        val telaLogin = Intent(this@MenuActivity, LoginActivity::class.java)
        startActivity(telaLogin)
    }

    fun goToMaps() {
        val telaMaps = Intent(this, FindLocationMapsActivity::class.java)
        startActivity(telaMaps)
    }

    fun trazerNome(){
        preferencias = getSharedPreferences("Autenticacao",Context.MODE_PRIVATE)
        val nome = preferencias?.getString("nome",null)
        user_name.text=nome
    }

    override fun onBackPressed() {
        Toast.makeText(this, getString(R.string.msg_voltar_erro), Toast.LENGTH_SHORT).show()
    }
}