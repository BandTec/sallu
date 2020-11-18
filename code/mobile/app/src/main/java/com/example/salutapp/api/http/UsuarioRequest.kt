package com.example.salutapp.api.http

import com.example.salutapp.api.dto.UsuarioDto
import com.example.salutapp.api.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UsuarioRequest {
    @PUT("/user")
    fun putUsuarioDados(@Body usuarioDto: UsuarioDto): Call<Void>

    @GET("/user/{id}")
    fun getUsuarioDados(@Path("id") id:Integer): Call<Usuario>
}