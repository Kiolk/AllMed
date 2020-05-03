package com.github.kiolk.allmed.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "drug_pattern")
data class DrugPattern(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_drug_pattern")
    val id: Int,
    @ColumnInfo(name = "start")
    val start: Date,
    @ColumnInfo(name = "end")
    val end: Date,
    @ForeignKey(entity = Drug::class, parentColumns = ["id_drug"],childColumns = ["drugId"], onDelete = CASCADE)
    val drugId: Int
)