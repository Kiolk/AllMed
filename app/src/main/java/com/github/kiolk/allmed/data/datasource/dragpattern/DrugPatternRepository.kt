package com.github.kiolk.allmed.data.datasource.dragpattern

import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.DrugPattern
import java.util.*

interface DrugPatternRepository {

    suspend fun savePattern(pattern: DrugPattern)

    suspend fun updatePattern(pattern: DrugPattern)

    suspend fun saveAcceptance(acceptances: List<Acceptance>)

    suspend fun getAcceptanceByDate(date: Date): List<Acceptance>
}