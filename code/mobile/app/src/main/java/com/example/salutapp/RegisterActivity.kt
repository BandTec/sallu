package com.example.salutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.salutapp.api.model.Registro
import com.example.salutapp.api.RetrofitConfig
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun cadastroPaciente(v: View) {
        val api = RetrofitConfig().requestRegistro()
        val name = etBgEmail.text.toString()
        val birthday = etBgAniversarioRegister.text.toString()
        val sex = etBgSexoRegister.text.toString()
        val email = etBgEmailRegister.text.toString()
        val password = etBgPasswordRegister.text.toString()
        val confirmPassword = etBgConfirmPassword.text.toString()

        val validaSenha = etBgPasswordRegister.length()
        if (password == confirmPassword && validaSenha >=8 ) {
            val usuario = Registro(
                name, birthday, false,
                sex, "5511967868853", email, password
            )
            val call = api.postUser(usuario)

            call.enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.code() == 201) {
                        Toast.makeText(this@RegisterActivity, getString(R.string.cadastro_feito), Toast.LENGTH_SHORT).show()
                        irTelaLogin()
                    }else{
                        Toast.makeText(this@RegisterActivity, "Erro no cadastro, tente novamente!", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Erro no cadastro $t", Toast.LENGTH_SHORT).show()
                }
            })
        }else {
            Toast.makeText(this,getString(R.string.erro_campo), Toast.LENGTH_SHORT).show()
        }
    }

    fun irTelaLogin(){
        val telaLogin = Intent(this, LoginActivity::class.java)
        startActivity(telaLogin)
    }
}