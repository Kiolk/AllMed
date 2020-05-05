package com.github.kiolk.allmed.presentation.adapter.doctor

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.BaseRecyclerAdapter
import com.github.kiolk.allmed.presentation.model.Doctor

class DoctorAdapter: BaseRecyclerAdapter<Doctor, DoctorViewHolder>() {

    init {
        addALl(listOf(stubDoctor, stubDoctor2))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.onViewBound(items[position])
    }
}