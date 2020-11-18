package com.example.salutapp.api.model

import java.math.BigDecimal

data class FichaMedica(
        val id: Int?,
        val hospital: Hospital,
        val weight: BigDecimal,
        val height: BigDecimal,
        val bloodPressure: BigDecimal,
        val bodyTemperature: BigDecimal,
        val allergy: String,
        val lastCycle: String,
        val isPregmant: Boolean,
        val referral: Classificacao,
        val createdAt: String,
        val pregnant: Boolean
)