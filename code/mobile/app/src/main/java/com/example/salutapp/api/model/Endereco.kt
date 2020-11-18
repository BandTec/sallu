package com.example.salutapp.api.model

data class Endereco (
        val id: Int?,
        val cep: String,
        val address: String,
        val district: String,
        val number: String,
        val city: String,
        val state: String
)