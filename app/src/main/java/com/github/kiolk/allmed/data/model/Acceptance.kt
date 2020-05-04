package com.github.kiolk.allmed.data.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.util.*

@Entity(tableName = "acceptance")
data class Acceptance(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_acceptance")
    val id: Int? = null,
    @ForeignKey(
        entity = DrugPattern::class,
        parentColumns = ["id_drug_pattern"],
        childColumns = ["patternId"],
        onDelete = CASCADE
    )
    val patternId: Int,
    @ForeignKey(
        entity = Drug::class,
        parentColumns = ["id_drug"],
        childColumns = ["drugId"]
    )
    val drugId: Int,
    @ColumnInfo(name = "accept_state")
    val acceptState: String,
    @ColumnInfo(name = "accepted_in")
    val acceptedIn: Date,
    @ColumnInfo(name = "start_accept_period")
    val start: Date,
    @ColumnInfo(name = "end_accept_period")
    val end: Date
)