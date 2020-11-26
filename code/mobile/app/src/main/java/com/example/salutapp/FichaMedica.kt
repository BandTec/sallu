package com.example.salutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.marginBottom
import com.example.salutapp.api.RetrofitConfig
import com.example.salutapp.api.dto.ClassificacaoDto
import com.example.salutapp.api.dto.FichaMedicaDto
import com.example.salutapp.api.dto.UsuarioDto
import com.example.salutapp.api.model.HospitalAdapter
import kotlinx.android.synthetic.main.activity_configuracao.*
import kotlinx.android.synthetic.main.activity_ficha_medica.*
import kotlinx.android.synthetic.main.activity_ficha_medica.swAlteracaoFinalizada
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

        var token= intent.extras?.getString("token")
        val selecionado = lv_hospitais.selectedItem.toString()
        val id = hospitais.find { it.nome == selecionado }?.id
        println(id)
        println(token)

        if(token == null){
            return
        }

        val gravida: Boolean
        if(swAlteracaoFinalizada.isChecked){
            gravida = true
        }else{
            gravida = false
        }

        val api = RetrofitConfig().requestFichaMedica()
        val classificacao = ClassificacaoDto(
                "vermelho",
                "1"
        )

        val fichaMedica = FichaMedicaDto(
                et_maisInformacoes.text.toString(),
                et_pressao.text.toString(),
                et_temperatura.text.toString(),
                et_altura.text.toString(),
                id.toString(),
                gravida,
                et_ultCiclo.text.toString(),
                classificacao,
                et_peso.text.toString()
        )

        val tokenUser = "Bearer ${token}"
        val callFichaMedica = api.postFichaMedica(fichaMedica,tokenUser)
        callFichaMedica.enqueue(object: Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.code() == 201) {
                    Toast.makeText(this@FichaMedica, getString(R.string.msg_sucesso_ficha), Toast.LENGTH_SHORT).show()
                    println("status code = ${response.code()}")
                    println("resposta = ${response}")
                }else{
                    println(response.code())
                    Toast.makeText(this@FichaMedica,getString(R.string.msg_erro_ficha) , Toast.LENGTH_SHORT).show()
                    println("status code = ${response.code()}")
                    println("resposta = ${response}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "Erro no envio $t", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun enviarEmailMedico(){

    }
}