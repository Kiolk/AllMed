package com.github.kiolk.allmed.presentation.adapter.symptoms

import android.view.View
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.BaseViewHolder
import com.github.kiolk.allmed.presentation.enums.Symptoms
import kotlinx.android.synthetic.main.layout_symptom.view.*

class SymptomsViewHolder(itemView: View) : BaseViewHolder<Symptoms>(itemView) {

    var isSelected: Boolean = false

    override fun onViewBound(item: Symptoms, callBack: ((Symptoms) -> Unit)?) {
        itemView.tv_symptom.text = itemView.context.getString(item.stringId)
        itemView.iv_symptom.setImageDrawable(itemView.context.getDrawable(item.drawableId))

        updateBackground()

        itemView.vg_symptom_container.setOnClickListener {
            isSelected = !isSelected
            updateBackground()
        }
    }

    private fun updateBackground() {
        if (isSelected) {
            itemView.vg_symptom_container.background =
                itemView.context.getDrawable(R.drawable.bg_gray_rounded)
        } else {
            itemView.vg_symptom_container.background =
                itemView.context.getDrawable(R.drawable.bg_white_rounded)
        }
    }
}