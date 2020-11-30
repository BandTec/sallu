package com.example.salutapp.api.model

import java.math.BigDecimal

data class DadosFicha (
        val nome: String,
        val tel: String,
        val pressao: BigDecimal,
        val temperatura: BigDecimal
)