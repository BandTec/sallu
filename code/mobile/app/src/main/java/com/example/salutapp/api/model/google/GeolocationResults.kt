package com.example.salutapp.api.model.google

data class GeolocationResults(
    val business_status: String,
    val geometry: GeolocationGeometryResults,
    val name: String,
    val icon: String,
    val opening_hours: GeolocationOpeningHours?,
    val place_id: String,
    val plus_code: GeolocationPlusCode,
    val rating: Number?,
    val reference: String,
    val scrope: String,
    val types: List<String>,
    val user_ratings_total: Number,
    val vicinity: String
)