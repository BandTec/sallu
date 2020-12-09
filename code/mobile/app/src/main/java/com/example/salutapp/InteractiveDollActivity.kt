package com.example.salutapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.salutapp.api.http.EmailRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InteractiveDollActivity : AppCompatActivity() {
    val list = mutableListOf<String>()
    var preferencias: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interactive_doll)

        setSingleEvent();

        val btnMapa : Button = findViewById(R.id.btnMapa);

        btnMapa.setOnClickListener {
            enviarEmail()
            //enterMapa();
        }
    }

     fun setSingleEvent() {
         findViewById<CardView>(R.id.cd_head).setOnClickListener {

             if(list.find { it == "Dor de Cabeça" } == null) list.add("Dor de Cabeça") else
                 list.remove("Dor de Cabeça")
             Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_sintoma_emergencia) , Toast.LENGTH_SHORT).show()
         }

         findViewById<CardView>(R.id.cd_eye).setOnClickListener {
             if(list.find { it == "Dores na Vista" } == null) list.add("Dores na Vista") else
                 list.remove("Dores na Vista")
             Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_sintoma_emergencia) , Toast.LENGTH_SHORT).show()
         }

         findViewById<CardView>(R.id.cd_kindey).setOnClickListener {
             if(list.find { it == "Dores nos Rins" } == null) list.add("Dores nos Rins") else
                 list.remove("Dores nos Rins")
             Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_sintoma_emergencia) , Toast.LENGTH_SHORT).show()
         }

         findViewById<CardView>(R.id.cd_liver).setOnClickListener {
             if(list.find { it == "Dor no Fígado" } == null) list.add("Dor no Fígado") else
                 list.remove("Dor no Fígado")
             Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_sintoma_emergencia) , Toast.LENGTH_SHORT).show()
         }

         findViewById<CardView>(R.id.cd_lung).setOnClickListener {
             if(list.find { it == "Dores no Pulmão" } == null) list.add("Dores no Pulmão") else
                 list.remove("Dores no Pulmão")
             Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_sintoma_emergencia) , Toast.LENGTH_SHORT).show()
         }

         findViewById<CardView>(R.id.cd_heart).setOnClickListener {
             if(list.find { it == "Dores Cardíacas" } == null) list.add("Dores Cardíacas") else
                 list.remove("Dores Cardíacas")
             Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_sintoma_emergencia) , Toast.LENGTH_SHORT).show()
         }

         findViewById<CardView>(R.id.cd_bones).setOnClickListener {
             if(list.find { it == "Dor nos Ossos" } == null) list.add("Dor nos Ossos") else
                 list.remove("Dor nos Ossos")
             Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_sintoma_emergencia) , Toast.LENGTH_SHORT).show()
         }

         findViewById<CardView>(R.id.cd_veins).setOnClickListener {
             if(list.find { it == "Problemas nas Veias" } == null) list.add("Problemas nas Veias") else
                 list.remove("Problemas nas Veias")
             Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_sintoma_emergencia) , Toast.LENGTH_SHORT).show()
         }
     }

    private fun enterMapa() {
        val intent = Intent(this, FindLocationMapsActivity::class.java)
        intent.putExtra("agora vai", list.toString())
        startActivity(intent);
    }

    fun enviarEmail(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://sallu-email-api-dot-code-projects-296414.rj.r.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val requests = retrofit.create(EmailRequest::class.java)
        preferencias = getSharedPreferences("Autenticacao", Context.MODE_PRIVATE)
        val nome = preferencias?.getString("nome",null)
        val email = preferencias?.getString("email",null)

        val callEmail = requests.enviarEmail("${nome}", "${email}","Quebra de ossos","Problemas Cardiacos")

        callEmail.enqueue(object: Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: $t", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.code() == 200) {
                    Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_email_emergencia_sucesso) , Toast.LENGTH_SHORT).show()
                    enterMapa()
                }else{
                    Toast.makeText(this@InteractiveDollActivity,getString(R.string.msg_email_emergencia_erro) , Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
