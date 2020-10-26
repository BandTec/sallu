package com.example.salutapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://5f9361ad8742070016da690c.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun requestRegistro() = retrofit.create(RequestRegistro::class.java)
}