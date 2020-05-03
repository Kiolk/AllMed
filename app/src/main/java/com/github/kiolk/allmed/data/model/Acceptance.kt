package com.github.kiolk.allmed.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "acceptance")
data class Acceptance(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_acceptance")
    val id: Int,
    @ForeignKey(
        entity = DrugPattern::class,
        parentColumns = ["id_drug_pattern"],
        childColumns = ["patternId"],
        onDelete = CASCADE
    )
    val patternId: Int
)