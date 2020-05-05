package com.github.kiolk.allmed.presentation.adapter.diagnostic

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.BaseRecyclerAdapter
import com.github.kiolk.allmed.presentation.model.Diagnostic

class DiagnosticAdapter: BaseRecyclerAdapter<Diagnostic, DiagnosticViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiagnosticViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_diagnostic, parent, false)
        return DiagnosticViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiagnosticViewHolder, position: Int) {
        holder.onViewBound(items[position])
    }
}