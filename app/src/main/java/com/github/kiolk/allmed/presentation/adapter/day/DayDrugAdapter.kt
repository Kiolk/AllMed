package com.github.kiolk.allmed.presentation.adapter.day

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.presentation.adapter.BaseRecyclerAdapter
import java.util.zip.Inflater

class DayDrugAdapter : BaseRecyclerAdapter<Acceptance, DayDrugViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayDrugViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layour_acceptance, parent, false)
        return DayDrugViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayDrugViewHolder, position: Int) {
        holder.onViewBound(items[position])
    }
}