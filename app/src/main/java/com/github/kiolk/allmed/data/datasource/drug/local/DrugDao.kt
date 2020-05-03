package com.github.kiolk.allmed.data.datasource.drug.local

import androidx.room.Dao
import androidx.room.Query
import com.github.kiolk.allmed.data.database.BaseDao
import com.github.kiolk.allmed.data.model.Drug

@Dao
interface DrugDao: BaseDao<Drug> {

    @Query("SELECT * FROM drug")
    suspend fun getAllDrugs(): List<Drug>
}