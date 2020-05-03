package com.github.kiolk.allmed.presentation.adapter.day

import android.view.View
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.presentation.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.layour_acceptance.view.*

class DayDrugViewHolder(itemView: View): BaseViewHolder<Acceptance>(itemView) {

    override fun onViewBound(item: Acceptance, callBack: ((Acceptance) -> Unit)?) {
        itemView.tv_drug_name.text = item.drugId.toString()
        itemView.tv_acceptance_in.text = "${item.start} - ${item.end}"
    }
}