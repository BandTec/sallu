package com.example.salutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.salutapp.api.RetrofitConfig
import com.example.salutapp.api.model.Usuario
import kotlinx.android.synthetic.main.activity_configuracao.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoricoMedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_medico)
    }

    fun listarFichas(){
        var idUsuario= intent.extras?.getString("id")
        val api = RetrofitConfig().requestUsuario()
        val callUsuario = api.getUsuarioDados(Integer(idUsuario))

        callUsuario.enqueue(object: Callback<Usuario>{
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(applicationContext, "Deu ruim $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {

            }
        })
    }
}