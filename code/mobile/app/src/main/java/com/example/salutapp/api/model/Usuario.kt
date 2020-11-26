package com.example.salutapp.api.model

data class Usuario (
        val id: Int,
        val medicalRecords: List<FichaMedica>,
        val name: String,
        val cellphone: String,
        val birthday: String,
        val sex: String,
        val email: String,
        val password: String,
        val isAdmin: Boolean
)

