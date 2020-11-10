package com.example.salutapp.api.http
import com.example.salutapp.api.model.Login
import com.example.salutapp.api.model.Token
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRequest {
    @POST("/auth")
    fun postLogin(@Body login: Login): Call<Void>

    // DADOS DA CONTA
    //@GET("/logado")
    //fun getDadosConta(
      //  @Header("authorization") auth: String
    //): Call<UserZenite>
}