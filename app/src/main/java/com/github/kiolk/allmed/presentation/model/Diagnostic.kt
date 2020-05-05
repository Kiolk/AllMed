package com.github.kiolk.allmed.presentation.model

import com.github.kiolk.allmed.presentation.enums.Status
import java.util.*

data class Diagnostic(
    val name: String,
    val date: Date,
    val status: Status
)