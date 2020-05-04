package com.github.kiolk.allmed.data.datasource.dragpattern

import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.DrugPattern
import com.github.kiolk.allmed.data.model.FullAcceptance
import java.util.*

interface DrugPatternDataSource {

    suspend fun savePattern(pattern: DrugPattern): Long

    suspend fun updatePattern(pattern: DrugPattern)

    suspend fun saveAcceptance(acceptances: List<Acceptance>)

    suspend fun getAcceptanceByDate(date: Date): List<FullAcceptance>
}