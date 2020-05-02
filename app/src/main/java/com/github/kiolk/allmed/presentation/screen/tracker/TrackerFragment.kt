package com.github.kiolk.allmed.presentation.screen.tracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrackerFragment : BaseFragment<TrackerViewModel>() {

    override val viewModel: TrackerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tracker, container, false)
    }
}
