package com.github.kiolk.allmed.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.kiolk.allmed.converter.DateConverter
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.Drug
import com.github.kiolk.allmed.data.model.DrugPattern

@Database(entities = [Acceptance::class, Drug::class, DrugPattern::class],
version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase: RoomDatabase() {
}