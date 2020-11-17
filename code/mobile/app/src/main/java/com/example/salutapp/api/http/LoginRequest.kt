package com.example.salutapp.api.http
import com.example.salutapp.api.model.Login
import com.example.salutapp.api.model.Token
import com.example.salutapp.api.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginRequest {
    @Headers("Content-Type: application/json")
    @POST("/auth")
    fun postLogin(@Body login: Login): Call<User>

    // DADOS DA CONTA
    //@GET("/logado")
    //fun getDadosConta(
      //  @Header("authorization") auth: String
    //): Call<UserZenite>
}