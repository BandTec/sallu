package com.example.salutapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/f1c2be63-16b3-45d7-b5d4-c513fd73841c/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun requestRegistro() = retrofit.create(RequestRegistro::class.java)
}