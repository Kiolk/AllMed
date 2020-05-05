package com.github.kiolk.allmed.presentation.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.github.kiolk.allmed.R

enum class Symptoms(@DrawableRes val drawableId: Int, @StringRes val stringId: Int) {
    COUGH(R.drawable.ic_cough, R.string.cough),
    TEMPERATURE(R.drawable.ic_cough, R.string.temperature),
    RUNNY_NOSE(R.drawable.ic_cough, R.string.runny),
    SCORE_THROAT(R.drawable.ic_cough, R.string.score_throat),
    NAUSEA(R.drawable.ic_cough, R.string.nausea),
    SIK_HEAD(R.drawable.ic_cough, R.string.sik_head),
    PHOTOPHOBIA(R.drawable.ic_cough, R.string.photophobia),
}