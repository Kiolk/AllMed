package com.github.kiolk.allmed.data.datasource.dragpattern

import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.DrugPattern
import com.github.kiolk.allmed.data.model.FullAcceptance
import java.util.*

class DefaultDrugPatternRepository(private val local: DrugPatternDataSource): DrugPatternRepository {

    override suspend fun savePattern(pattern: DrugPattern) = local.savePattern(pattern)

    override suspend fun updatePattern(pattern: DrugPattern) = local.updatePattern(pattern)

    override suspend fun saveAcceptance(acceptances: List<Acceptance>) = local.saveAcceptance(acceptances)

    override suspend fun getAcceptanceByDate(date: Date): List<FullAcceptance> = local.getAcceptanceByDate(date)
}