package com.github.kiolk.allmed.data.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(items: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(item: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: T)
}