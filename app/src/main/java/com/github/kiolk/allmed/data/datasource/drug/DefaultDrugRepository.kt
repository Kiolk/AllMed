package com.github.kiolk.allmed.data.datasource.drug

import com.github.kiolk.allmed.data.model.Drug

class DefaultDrugRepository(private val local: DrugDataSource): DragRepository {

    override suspend fun saveDrug(drugs: List<Drug>) = local.saveDrug(drugs)

    override suspend fun getAllDrugs(): List<Drug> = local.getAllDrugs()
}