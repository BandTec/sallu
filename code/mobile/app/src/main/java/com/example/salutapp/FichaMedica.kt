package com.example.salutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.marginBottom
import com.example.salutapp.api.RetrofitConfig
import com.example.salutapp.api.model.HospitalAdapter
import kotlinx.android.synthetic.main.activity_ficha_medica.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FichaMedica : AppCompatActivity() {
    val hospitais= mutableListOf<HospitalAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_medica)
        listarHospitais()
        camposFemininos()
    }

    fun listarHospitais () {
        val api = RetrofitConfig().requestHospitais()
        val callHospitais = api.getHospitais()

        callHospitais.enqueue(object: Callback<List<HospitalAdapter>> {
            override fun onFailure(call: Call<List<HospitalAdapter>>, t: Throwable) {
                Toast.makeText(applicationContext, "Deu ruim $t", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<HospitalAdapter>>, response: Response<List<HospitalAdapter>>) {
                val lista = response.body()!!
                hospitais.clear()
                hospitais.addAll(lista)
                val nomes = lista.map { it.nome }

                val ad = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, nomes)
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                lv_hospitais.setAdapter(ad)
            }
        })
    }

    fun camposFemininos(){
        var generoUsuario= intent.extras?.getString("genero")

        if (generoUsuario.equals("F") || generoUsuario.equals("f")){
            et_ultCiclo.visibility = View.VISIBLE
            swAlteracaoFinalizada.visibility = View.VISIBLE
        }else{

        }
    }

    fun enviar (v : View){
        val selecionado = lv_hospitais.selectedItem.toString()
        val id = hospitais.find { it.nome == selecionado }?.id
        println(id)
    }
}