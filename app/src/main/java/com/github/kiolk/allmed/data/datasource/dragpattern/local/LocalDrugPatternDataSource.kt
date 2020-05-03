package com.github.kiolk.allmed.data.datasource.dragpattern.local

import com.github.kiolk.allmed.data.datasource.dragpattern.DrugPatternDataSource
import com.github.kiolk.allmed.data.exstentions.endDate
import com.github.kiolk.allmed.data.exstentions.startDay
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.DrugPattern
import java.util.*

class LocalDrugPatternDataSource(
    private val drugPatternDao: DrugPatternDao,
    private val acceptanceDao: AcceptanceDao
) : DrugPatternDataSource {

    override suspend fun savePattern(pattern: DrugPattern) = drugPatternDao.save(pattern)

    override suspend fun updatePattern(pattern: DrugPattern) = drugPatternDao.update(pattern)

    override suspend fun saveAcceptance(acceptances: List<Acceptance>) = acceptanceDao.save(acceptances)

    override suspend fun getAcceptanceByDate(date: Date): List<Acceptance> = acceptanceDao.getAcceptancesForDate(date.startDay(), date.endDate())
}