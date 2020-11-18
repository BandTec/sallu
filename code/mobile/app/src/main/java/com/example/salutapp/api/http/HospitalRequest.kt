package com.example.salutapp.api.http

import com.example.salutapp.api.model.HospitalAdapter
import retrofit2.Call
import retrofit2.http.GET

interface HospitalRequest {
    @GET("/hospital")
    fun getHospitais(): Call<List<HospitalAdapter>>
}