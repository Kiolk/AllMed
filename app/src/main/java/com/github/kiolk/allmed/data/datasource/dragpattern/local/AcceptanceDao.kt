package com.github.kiolk.allmed.data.datasource.dragpattern.local

import androidx.room.Dao
import androidx.room.Query
import com.github.kiolk.allmed.data.database.BaseDao
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.FullAcceptance

@Dao
interface AcceptanceDao: BaseDao<Acceptance> {

    @Query("SELECT * FROM acceptance WHERE start_accept_period > :startTime AND end_accept_period < :endTime")
    suspend fun getAcceptancesForDate(startTime: Long, endTime: Long): List<FullAcceptance>
}