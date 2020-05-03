package com.github.kiolk.allmed.presentation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class NotSwipeViewPager @JvmOverloads constructor(context: Context, attr: AttributeSet? = null) :
    ViewPager(context, attr) {

    var isEnable: Boolean = false

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (isEnable) {
            return super.onInterceptTouchEvent(ev)
        }

        return false
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (isEnable) {
            return super.onTouchEvent(ev)
        }

        return false
    }
}