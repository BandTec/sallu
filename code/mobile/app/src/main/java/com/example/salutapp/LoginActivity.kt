package com.example.salutapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.salutapp.api.RetrofitConfig
import com.example.salutapp.api.model.Login
import com.example.salutapp.api.model.Token
import com.example.salutapp.api.model.User
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    var preferencias: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        preferencias = getPreferences(Context.MODE_PRIVATE)
        val usuario = preferencias?.getString("usuario", null)
        val login = preferencias?.getString("login", null)
        val senha = preferencias?.getString("senha", null)
        val id = preferencias?.getString("id", null)
        if (usuario != null && senha != null && id != null && login != null){
            irTelaPrincipal()
        }
    }

    fun verificarDados(view: View) {
        //validations
        val email = etBgUsername.text.toString().trim()
        val senha = etBgPassword.text.toString().trim()

        if (email.isBlank()) {
            etBgEmail.error = getString(R.string.login_error_campo)
            etBgEmail.requestFocus()
        } else if (senha.isBlank()) {
            etBgPassword.error = getString(R.string.login_error_campo);
            etBgPassword.requestFocus()
        }else {
            logar()
        }
    }

    fun logar() {
        val api = RetrofitConfig().requestLogin()
        val login = Login(
            etBgUsername.text.toString(),
            etBgPassword.text.toString()
        )

        val LoginRequest = api.postLogin(login)
        LoginRequest.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, getString(R.string.erro_autentificacao), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.code() == 202) {
                    Toast.makeText(this@LoginActivity,getString(R.string.sucesso_autentificacao), Toast.LENGTH_SHORT).show()
                    irTelaPrincipal()
                }else{
                    Toast.makeText(this@LoginActivity, getString(R.string.erro_autentificacao_dados), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun irTelaPrincipal(){
        val telaPrincipal = Intent(this, MenuActivity::class.java)
        startActivity(telaPrincipal)
    }

    fun irTelaCadastro(v:View){
        val telaCadastro = Intent(this, RegisterActivity::class.java)
        startActivity(telaCadastro)
    }
}