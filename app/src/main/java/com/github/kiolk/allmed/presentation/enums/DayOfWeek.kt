package com.github.kiolk.allmed.presentation.enums

import androidx.annotation.StringRes
import com.github.kiolk.allmed.R

enum class DayOfWeek(@StringRes private val stringRes: Int) {
    MONDAY(R.string.monday), TUESDAY(R.string.tuesday), WEDNESDAY(R.string.wednesday), THURSDAY(R.string.thursday), FRIDAY(R.string.friday), SATURDAY(R.string.saturday), SUNDAY(R.string.sunday);

    companion object {
        fun getString(day: Int) = values()[day].stringRes
    }
}