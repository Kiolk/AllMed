package com.github.kiolk.allmed.presentation.adapter.doctor

import android.view.View
import com.bumptech.glide.Glide
import com.github.kiolk.allmed.data.exstentions.toHHMMDDMMYYYY
import com.github.kiolk.allmed.presentation.adapter.BaseViewHolder
import com.github.kiolk.allmed.presentation.model.Doctor
import kotlinx.android.synthetic.main.layout_doctor.view.*

class DoctorViewHolder(itemView: View) : BaseViewHolder<Doctor>(itemView) {

    override fun onViewBound(item: Doctor, callBack: ((Doctor) -> Unit)?) {
        Glide.with(itemView).load(item.image).into(itemView.iv_doctor_image)
        itemView.tv_doctor_name.text = item.name
        itemView.tv_doctor_position.text = item.position
        itemView.tv_chat_time.text = item.consultationTime.toHHMMDDMMYYYY()
        itemView.tv_doctor_description.text = item.description
    }
}