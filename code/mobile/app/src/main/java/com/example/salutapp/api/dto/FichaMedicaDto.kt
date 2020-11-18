package com.example.salutapp.api.dto

import java.math.BigDecimal

data class FichaMedicaDto (
        val weight: BigDecimal,
        val height: BigDecimal,
        val bloodPressure: BigDecimal,
        val bodyTemperature: BigDecimal,
        val allergy: String,
        val lastCycle: String,
        val createdAt: String,
        val isPregnant: Boolean,
        val hospitalId: Int,
        val referral: ClassificacaoDto
)