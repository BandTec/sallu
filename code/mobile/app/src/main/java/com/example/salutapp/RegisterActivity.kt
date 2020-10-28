package com.example.salutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.salutapp.api.Registro
import com.example.salutapp.api.RetrofitConfig
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var btnRegister: Button = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener {
            openMenu()
        }
    }

    private fun openMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

    fun cadastroPaciente(v: View) {

        val api = RetrofitConfig().requestRegistro()
        val name = etBgEmail.text.toString()
        val birthday = etBgAniversarioRegister.text.toString()
        val sex = etBgSexoRegister.text.toString()
        val email = etBgEmail.text.toString()
        val password = etBgPasswordRegister.text.toString()
        val confirmPassword = etBgConfirmPassword.text.toString()

        if (password == confirmPassword) {
            val usuario = Registro("Giovanna Souza","2000-01-01",false,
                "F","5511912345678","giovanna.souza@gmail.com","bandtec@sallu")
            val call = api.postUser(usuario)

            call.enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Cadastro realizado", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Erro no cadastro $t", Toast.LENGTH_SHORT).show()
                }
            })

            val telaLogin = Intent(this, LoginActivity::class.java)
            startActivity(telaLogin)
        }else {
            Toast.makeText(this, "Senhas não coicidem", Toast.LENGTH_SHORT).show()
        }
    }
}