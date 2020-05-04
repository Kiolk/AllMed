package com.github.kiolk.allmed.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drug")
data class Drug(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_drug")
    val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image_url")
    val image: String
)