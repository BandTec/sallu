package com.example.salutapp.api.model

data class Registro(
    val name: String,
    val birthday: String,
    val isAdmin: Boolean,
    val sex: String,
    val cellphone: String?,
    val email: String,
    val password: String
)
