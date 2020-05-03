package com.github.kiolk.allmed.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager

abstract class BaseRecyclerAdapter<T, VM : RecyclerView.ViewHolder>(val requestManager: RequestManager? = null) :
    RecyclerView.Adapter<VM>() {

    protected var items: MutableList<T> = ArrayList()

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = NORMAL_TYPE

    open fun addALl(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    open fun getItem(position: Int): T? = if (items.size != 0) items[position] else null

    companion object {
        const val NORMAL_TYPE = 0
    }
}