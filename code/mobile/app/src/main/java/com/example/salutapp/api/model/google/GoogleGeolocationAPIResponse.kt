package com.example.salutapp.api.model.google

data class GoogleGeolocationAPIResponse(
    val results: List<GeolocationResults>,
    val status: String
)