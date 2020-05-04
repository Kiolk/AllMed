package com.github.kiolk.allmed.data.converter

import androidx.room.TypeConverter
import com.github.kiolk.allmed.data.exstentions.ONE_DAY_MILLISECONDS
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}