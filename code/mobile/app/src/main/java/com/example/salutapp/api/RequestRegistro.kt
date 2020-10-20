package com.example.salutapp.api
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RequestRegistro {

    @GET("user")
    fun getUsers(): Call<List<Registro>>

    @POST("user")
    fun postUser(@Body registro: Registro):Call<Registro>
}