package com.example.salutapp.api

import com.example.salutapp.api.http.HospitalRequest
import com.example.salutapp.api.http.LoginRequest
import com.example.salutapp.api.http.RequestRegistro
import com.example.salutapp.api.http.UsuarioRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://54.91.66.212:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun requestRegistro() = retrofit.create(RequestRegistro::class.java)
    fun requestLogin()= retrofit.create(LoginRequest::class.java)
    fun requestHospitais()= retrofit.create(HospitalRequest::class.java)
    fun requestUsuario()= retrofit.create(UsuarioRequest::class.java)
}