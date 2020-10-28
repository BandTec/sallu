package com.example.salutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.salutapp.api.Login
import com.example.salutapp.api.Registro
import com.example.salutapp.api.RetrofitConfig
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var tvSingIn: TextView = findViewById(R.id.tvSingIn);

        tvSingIn.setOnClickListener {
            openNexdActivity()
        }
    }

    private fun openNexdActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun login(compomente:View){
        val api = RetrofitConfig().requestLogin()
        val name = etBgUsername.text.toString()
        val password = etBgPassword.text.toString()
        val login = Login("giovanna.souza@gmail.com","bandtec@sallu")
        val call = api.postLogin(login)


        call.enqueue(object: Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(applicationContext, "Login feito com sucesso", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "Erro no lofin $t", Toast.LENGTH_SHORT).show()
            }
        })

        val telaBemVindo = Intent(this, MenuActivity::class.java)
        startActivity(telaBemVindo)
    }
}