package com.example.salutapp.api.dto

import java.math.BigDecimal

data class FichaMedicaDto (
        val allergy: String,
        val bloodPressure: String,
        val bodyTemperature: String,
        val height: String,
        val hospitalId: String?,
        val isPregnant: Boolean?,
        val lastCycle: String?,
        val referral: ClassificacaoDto,
        val weight: String
)