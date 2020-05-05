package com.github.kiolk.allmed.presentation.adapter.diagnostic

import android.view.View
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.data.exstentions.ONE_DAY_MILLISECONDS
import com.github.kiolk.allmed.data.exstentions.toDDMMYYYY
import com.github.kiolk.allmed.presentation.adapter.BaseViewHolder
import com.github.kiolk.allmed.presentation.enums.Status
import com.github.kiolk.allmed.presentation.model.Diagnostic
import kotlinx.android.synthetic.main.layout_diagnostic.view.*

class DiagnosticViewHolder(itemView: View): BaseViewHolder<Diagnostic>(itemView) {

    override fun onViewBound(item: Diagnostic, callBack: ((Diagnostic) -> Unit)?) {
        itemView.tv_diagnostic_name.text = item.name
        itemView.tv_diagnostic_date.text = item.date.toDDMMYYYY()
        itemView.tv_diagnostic_status.text = when(item.status) {
            Status.SCHEDULED -> {
                itemView.tv_diagnostic_status.setTextColor(itemView.context.resources.getColor(R.color.dark_green))
                "Через " + ((item.date.time - System.currentTimeMillis()) / ONE_DAY_MILLISECONDS).toInt().toString() + " дня"
            }
            Status.COMPLETED -> {
                itemView.tv_diagnostic_status.setTextColor(itemView.context.resources.getColor(R.color.base_yellow))
                "Результаты готовы"
            }
            Status.CANCELED -> {
                itemView.tv_diagnostic_status.setTextColor(itemView.context.resources.getColor(R.color.base_red))
                "Пропуск"
            }
        }
    }
}