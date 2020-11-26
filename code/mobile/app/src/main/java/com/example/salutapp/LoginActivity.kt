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
        preferencias = getSharedPreferences("Autenticacao",Context.MODE_PRIVATE)

        val id = preferencias?.getString("id",null)
        val nome = preferencias?.getString("nome",null)
        val genero = preferencias?.getString("genero",null)
        val token = preferencias?.getString("token",null)

        if (nome != null  && id != null && genero != null && token != null){
            irTelaPrincipal()
        }
    }

    fun verificarDados(v: View) {
        //validations
        val email = etBgEmail?.text.toString().trim()
        val senha = etBgPassword?.text.toString().trim()

        if (email.isBlank()) {
            etBgEmail.error = getString(R.string.login_error_campo)
            etBgEmail.requestFocus()
        }else if (senha.isBlank()) {
            etBgPassword.error = getString(R.string.login_error_campo)
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
        LoginRequest.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(baseContext, "falhou $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.code() == 202) {
                    Toast.makeText(this@LoginActivity,getString(R.string.sucesso_autentificacao), Toast.LENGTH_SHORT).show()
                    val telaHome = Intent(this@LoginActivity, MenuActivity::class.java)
                    var id : Int = 0
                    var nome: String = ""
                    var genero: String =""
                    var token: String = ""
                    response?.body()?.let {
                        //it é o corpo de retorno da requisição
                        id= it.user.id
                        nome = it.user.name
                        genero= it.user.sex
                        token = it.token
                        println(nome);
                        println(id)
                        println(genero)
                        println(token)
                    }
                    telaHome.putExtra("id",id.toString())
                    telaHome.putExtra("nome",nome)
                    telaHome.putExtra("genero",genero)
                    telaHome.putExtra("token",token)
                    val editor = preferencias?.edit()
                    editor?.putString("nome",nome)
                    editor?.putString("genero",genero)
                    editor?.putString("id",id.toString())
                    editor?.putString("token",token)
                    editor?.commit()
                    startActivity(telaHome)
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

    fun irTelaCadastro(v: View){
        val telaCadastro = Intent(this, RegisterActivity::class.java)
        startActivity(telaCadastro)
    }
}