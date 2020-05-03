package com.github.kiolk.allmed.data.datasource.dragpattern.local

import androidx.room.Dao
import com.github.kiolk.allmed.data.database.BaseDao
import com.github.kiolk.allmed.data.model.DrugPattern

@Dao
interface DrugPatternDao: BaseDao<DrugPattern> {

}