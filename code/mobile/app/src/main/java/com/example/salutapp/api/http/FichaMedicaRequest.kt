package com.example.salutapp.api.http
import com.example.salutapp.api.dto.FichaMedicaDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FichaMedicaRequest {
    @POST("/medical_records")
    fun postFichaMedica(@Body fichaMedica: FichaMedicaDto): Call<Void>
}