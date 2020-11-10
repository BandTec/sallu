package com.example.salutapp.api.http
import com.example.salutapp.api.model.Registro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RequestRegistro {
    @GET("/user")
    fun getUsers(): Call<List<Registro>>

    @Headers("Content-Type: application/json")
    @POST("/user")
    fun postUser(@Body registro: Registro):Call<Void>
}