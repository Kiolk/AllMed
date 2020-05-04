package com.github.kiolk.allmed.presentation.adapter.day

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.DrugPattern
import com.github.kiolk.allmed.data.model.FullAcceptance
import com.github.kiolk.allmed.presentation.adapter.BaseRecyclerAdapter
import com.github.kiolk.allmed.presentation.enums.AcceptanceState
import java.util.zip.Inflater

class DayDrugAdapter(private val callback: (FullAcceptance) -> Unit) : BaseRecyclerAdapter<FullAcceptance, DayDrugViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayDrugViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layour_acceptance, parent, false)
        return DayDrugViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> 0
            1 -> 1
            else -> 2
        }
    }

    override fun onBindViewHolder(holder: DayDrugViewHolder, position: Int) {
        holder.onViewBound(items[position], callback)
    }
}