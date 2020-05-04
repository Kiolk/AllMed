package com.github.kiolk.allmed.data.exstentions

import java.text.SimpleDateFormat
import java.util.*

const val ONE_DAY_MILLISECONDS = 24 * 60 * 60 * 1000
const val START_DAY_SINCE: Long = 7 * 60 * 60 * 1000
const val END_DAY_UNTIL: Long = 22 * 60 * 60 * 1000

val dateFormatter = SimpleDateFormat("HH             bb vggbfvvvbg:mm", Locale.ENGLISH)
val dayMonthYearFormatter = SimpleDateFormat("d MMM, YYYY", Locale.ENGLISH)

fun Date.startDay(): Long {
    return (this.time / ONE_DAY_MILLISECONDS) * ONE_DAY_MILLISECONDS
}

fun Date.endDate(): Long {
    return (this.time / ONE_DAY_MILLISECONDS) * ONE_DAY_MILLISECONDS + ONE_DAY_MILLISECONDS
}

fun Date.toDayTime(): String = dateFormatter.format(this)

fun Date.toDDMMYYYY(): String = dayMonthYearFormatter.format(this)