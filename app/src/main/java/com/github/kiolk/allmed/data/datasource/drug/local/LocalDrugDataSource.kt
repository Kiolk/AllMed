package com.github.kiolk.allmed.data.datasource.drug.local

import com.github.kiolk.allmed.data.datasource.drug.DrugDataSource
import com.github.kiolk.allmed.data.model.Drug

class LocalDrugDataSource(private val dao: DrugDao): DrugDataSource {

    override suspend fun saveDrug(drugs: List<Drug>) = dao.save(drugs)

    override suspend fun getAllDrugs(): List<Drug> = dao.getAllDrugs()
}
