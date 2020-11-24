package com.example.salutapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.salutapp.api.RetrofitConfig
import com.example.salutapp.api.model.Usuario
import kotlinx.android.synthetic.main.activity_configuracao.*
import kotlinx.android.synthetic.main.activity_historico_medico.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoricoMedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_medico)
        listarFichas()
    }

    fun listarFichas(){
        var idUsuario= intent.extras?.getString("id")
        val api = RetrofitConfig().requestUsuario()
        val callUsuario = api.getUsuarioDados(Integer(idUsuario))

        callUsuario.enqueue(object: Callback<Usuario>{
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(applicationContext, "Deu ruim $t", Toast.LENGTH_SHORT).show()
                println("status code = ${t}")
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    val resposta = response.body()
                    println("status code = ${response.code()}")
                    println("resposta = ${response}")
                println(response.body())
                //val fichas = listOf(response.body().medicalRecords)


               // tv_resposta1.text = "${resposta.medicalRecords}"

                //tv_resposta1.text = "${it.medicalRecords} "
            }
        })
    }
}