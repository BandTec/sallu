package com.example.salutapp.api

import com.example.salutapp.api.http.GoogleMapsRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GoogleMapsAPI() {
    private val retrofitNearbyHospitals = Retrofit.Builder()
        .baseUrl("https://maps.googleapis.com/maps/api/place/nearbysearch/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun requestGoogleMaps() = retrofitNearbyHospitals.create(GoogleMapsRequest::class.java)
}