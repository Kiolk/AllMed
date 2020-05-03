package com.github.kiolk.allmed.presentation.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.github.kiolk.allmed.data.exstentions.ONE_DAY_MILLISECONDS
import com.github.kiolk.allmed.presentation.enums.DayOfWeek
import com.github.kiolk.allmed.presentation.screen.tracker.day.DayFragment
import java.util.*

class TrackFragmentAdapter(private val context: Context, fm: FragmentManager, private val startWeekDate: Date): FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return DayFragment.newInstance(position, Date(startWeekDate.time + ONE_DAY_MILLISECONDS * position))
    }

    override fun getCount(): Int = DayOfWeek.values().size

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(DayOfWeek.getString(position))
    }
}