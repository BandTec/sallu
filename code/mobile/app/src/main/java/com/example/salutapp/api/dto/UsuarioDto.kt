package com.example.salutapp.api.dto

data class UsuarioDto (
        val name: String,
        val email: String,
        val cellphone: String,
        val isAdmin: Boolean,
        val birthday: String,
        val sex: String,
        //val password: String
)