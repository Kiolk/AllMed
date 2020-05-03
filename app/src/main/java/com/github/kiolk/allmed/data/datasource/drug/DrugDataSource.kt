package com.github.kiolk.allmed.data.datasource.drug

import com.github.kiolk.allmed.data.model.Drug

interface DrugDataSource {

    suspend fun saveDrug(drugs: List<Drug>)

    suspend fun getAllDrugs(): List<Drug>
}