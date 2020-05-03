package com.github.kiolk.allmed.di.module

import androidx.room.Room
import com.github.kiolk.allmed.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val DATABASE_NAME = "AllMed.db"

val applicationModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

//    single { get<AppDatabase>().excursionDao() }
//    single { get<AppDatabase>().pointDao() }
}