package com.github.kiolk.allmed.presentation.adapter.symptoms

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.BaseRecyclerAdapter
import com.github.kiolk.allmed.presentation.enums.Symptoms

class SymptomsAdapter : BaseRecyclerAdapter<Symptoms, SymptomsViewHolder>() {

    init {
        addALl(Symptoms.values().toList())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_symptom, parent, false)
        return SymptomsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SymptomsViewHolder, position: Int) {
        holder.onViewBound(items[position])
    }
}