package com.example.salutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.salutapp.api.Registro
import com.example.salutapp.api.RequestRegistro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fromtobtoom: Animation;
        var ivWelcome: ImageView = findViewById(R.id.ivWellcome);
        var tvTitle: TextView = findViewById(R.id.tvTitle);
        var btnLogin: Button = findViewById(R.id.btnLogin);
        var llSingup: LinearLayout = findViewById(R.id.llSingup);
        var tvRegister: TextView = findViewById(R.id.tvRegister);

        fromtobtoom = AnimationUtils.loadAnimation(this, R.anim.from_top_to_buttom_wellcome_screen);

        ivWelcome.startAnimation(fromtobtoom);
        tvTitle.startAnimation(fromtobtoom);
        btnLogin.startAnimation(fromtobtoom);
        llSingup.startAnimation(fromtobtoom)

        btnLogin.setOnClickListener {
            openNexdActivity()
        }

        tvRegister.setOnClickListener {
            nextActivity()
        }
    }

    private fun openNexdActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun nextActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}