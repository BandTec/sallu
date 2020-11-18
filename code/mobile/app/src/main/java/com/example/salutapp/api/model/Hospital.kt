package com.example.salutapp.api.model

data class Hospital (
        val id: Int?,
        val name: String,
        val cnpj: String,
        val telephone: String,
        val email: String,
        val address: Endereco
)