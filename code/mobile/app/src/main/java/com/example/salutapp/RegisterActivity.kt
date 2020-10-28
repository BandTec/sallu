package com.example.salutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.salutapp.api.Registro
import com.example.salutapp.api.RetrofitConfig
import kotlinx.android.synthetic.main.activity_register.*

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


   /* fun cadastro(componente:View){
        Registro registro = new Registro()
        val name = etBgEmail.text.toString()
        val password = etBgPasswordRegister.text.toString()
        val confirmaSenha = etBgConfirmPassword
        val call = RetrofitConfig().requestRegistro().postUser()

    }*/
}