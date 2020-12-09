package com.example.salutapp
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.salutapp.api.RetrofitConfig
import com.example.salutapp.api.model.DadosFicha
import com.example.salutapp.api.model.Usuario
import kotlinx.android.synthetic.main.activity_configuracao.*
import kotlinx.android.synthetic.main.activity_historico_medico.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoricoMedico : AppCompatActivity() {
    var preferencias: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_medico)
        listarFichas()
    }

    fun listarFichas(){
        preferencias = getSharedPreferences("Autenticacao", Context.MODE_PRIVATE)
        val id = preferencias?.getString("id",null)
        val api = RetrofitConfig().requestUsuario()
        val callUsuario = api.getUsuarioDados(Integer(id))

        callUsuario.enqueue(object: Callback<Usuario>{
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(applicationContext, "Deu ruim $t", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {

                val fichas = response.body()?.medicalRecords
                val dadosFicha = ArrayList<DadosFicha>()

                if (fichas != null) {
                    fichas.forEach{
                        dadosFicha.add(DadosFicha(
                                nome = it.hospital.name,
                                tel = it.hospital.telephone,
                                pressao = it.bloodPressure,
                                temperatura = it.bodyTemperature
                        ))
                    }
                }
                if (fichas != null) {
                    for (ficha in fichas){
                        val nomeHospital = TextView(baseContext)
                        val telefone = TextView(baseContext)
                        val pressao = TextView(baseContext)
                        val temperatura = TextView(baseContext)
                        val textoRespostaTxt = TextView(baseContext)
                        nomeHospital.text = ficha.hospital.name.toString()
                        telefone.text = ficha.hospital.telephone.toString()
                        pressao.text = ficha.bloodPressure.toString()
                        temperatura.text = ficha.bodyTemperature.toString()
                        var textoResposta = "${ficha.hospital.name.toString()}     ${ficha.hospital.telephone.toString()}  " +
                                "      ${ficha.bloodPressure.toString()}              ${ficha.bodyTemperature.toString()}\n"
                        textoRespostaTxt.text = textoResposta.toString()
                        ll_conteudo.addView(textoRespostaTxt)
                        //ll_conteudo.addView(telefone)
                        //ll_conteudo.addView(pressao)
                        //ll_conteudo.addView(temperatura)
                    }
                }
            }
        })
    }
}