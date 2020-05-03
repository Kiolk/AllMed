package com.github.kiolk.allmed.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.kiolk.allmed.data.converter.DateConverter
import com.github.kiolk.allmed.data.datasource.dragpattern.local.AcceptanceDao
import com.github.kiolk.allmed.data.datasource.dragpattern.local.DrugPatternDao
import com.github.kiolk.allmed.data.datasource.drug.local.DrugDao
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.Drug
import com.github.kiolk.allmed.data.model.DrugPattern

@Database(
    entities = [Acceptance::class, Drug::class, DrugPattern::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun drugDao(): DrugDao

    abstract fun drugPatternDao(): DrugPatternDao

    abstract fun acceptanceDao(): AcceptanceDao
}