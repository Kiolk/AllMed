package com.github.kiolk.allmed.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.bumptech.glide.RequestManager

abstract class BaseViewHolder<T>(item: View) :
    RecyclerView.ViewHolder(item) {

    init {
        ButterKnife.bind(this, item)
    }

    abstract fun onViewBound(
        item: T,
        callBack: ((T) -> Unit)? = null
    )
}