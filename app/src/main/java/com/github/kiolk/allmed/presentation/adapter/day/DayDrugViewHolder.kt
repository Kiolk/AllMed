package com.github.kiolk.allmed.presentation.adapter.day

import android.view.View
import com.bumptech.glide.Glide
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.data.exstentions.endDate
import com.github.kiolk.allmed.data.exstentions.toDayTime
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.FullAcceptance
import com.github.kiolk.allmed.presentation.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.layour_acceptance.view.*

class DayDrugViewHolder(itemView: View): BaseViewHolder<FullAcceptance>(itemView) {

    override fun onViewBound(item: FullAcceptance, callBack: ((FullAcceptance) -> Unit)?) {
        itemView.tv_drug_name.text = item.drug?.name
        itemView.tv_acceptance_in.text = "${item.acceptance.start.toDayTime()} - ${item.acceptance.end.toDayTime()}"
        Glide.with(itemView).load(item.drug?.image).into(itemView.iv_drug_image)
        itemView.tv_dozen_drug.text = item.pattern?.doze.toString()
        itemView.tv_unit_drug.text = item.pattern?.doze_unit
        itemView.vg_acceptance_card.background = itemView.context.getDrawable(R.drawable.bg_card)
        itemView.vg_acceptance_card.setOnClickListener {
            callBack?.invoke(item)
        }
    }
}