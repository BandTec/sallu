package com.example.salutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

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
        val telaBemVindo = Intent(this, MenuActivity::class.java)
        startActivity(telaBemVindo)
    }
}