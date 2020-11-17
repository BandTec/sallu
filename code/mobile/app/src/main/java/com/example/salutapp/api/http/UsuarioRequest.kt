package com.example.salutapp.api.http

import com.example.salutapp.api.model.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UsuarioRequest {
    @GET("/user/{id}")
    fun getUsuarioDados(@Path("id") id:Integer): Call<Usuario>
}