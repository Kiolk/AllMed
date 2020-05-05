package com.github.kiolk.allmed.presentation.model

import java.util.*

data class Doctor(
    val image: String,
    val name: String,
    val position: String,
    val consultationTime: Date,
    val description: String
)