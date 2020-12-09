package com.example.salutapp.api.http

import com.example.salutapp.api.model.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EmailRequest {

    @GET("/consulta/{nomePaciente}/{email}/{sintomas1}/{sintomas2}")
    fun enviarEmail(@Path("nomePaciente") nomePaciente: String, @Path("email")email: String,
    @Path("sintomas1") sintomas1: String, @Path("sintomas2") sintomas2: String): Call<Void>
}