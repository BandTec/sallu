package com.example.salutapp.api.http

import com.example.salutapp.api.model.google.GoogleGeolocationAPIResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface GoogleMapsRequest {

    @GET("json?radius=1500&types=hospital&key=AIzaSyCsOZbRpuSjiEG519RPYO6AgSw3JJzGOJg")
    fun getHospitalsNearby(
        @Query("location") location: String
    ): Call<GoogleGeolocationAPIResponse>
}
