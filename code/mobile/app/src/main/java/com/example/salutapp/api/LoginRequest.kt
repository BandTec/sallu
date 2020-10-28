package com.example.salutapp.api
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRequest {
    @POST("/auth")
    fun postLogin(@Body login:Login): Call<Void>
}