package com.github.kiolk.allmed.di.module

import com.github.kiolk.allmed.presentation.screen.adddrag.AddDragViewModel
import com.github.kiolk.allmed.presentation.screen.chat.ChatViewModel
import com.github.kiolk.allmed.presentation.screen.doctor.DoctorViewModel
import com.github.kiolk.allmed.presentation.screen.settings.SettingsViewModel
import com.github.kiolk.allmed.presentation.screen.splash.SplashViewModel
import com.github.kiolk.allmed.presentation.screen.tracker.TrackerViewModel
import com.github.kiolk.allmed.presentation.screen.tracker.day.DayViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
        viewModel { SplashViewModel(get()) }
        viewModel { ChatViewModel() }
        viewModel { SettingsViewModel() }
        viewModel { TrackerViewModel() }
        viewModel { DoctorViewModel() }
        viewModel { AddDragViewModel(get()) }
        viewModel { DayViewModel(get()) }
}