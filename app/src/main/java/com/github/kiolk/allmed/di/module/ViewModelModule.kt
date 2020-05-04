package com.github.kiolk.allmed.di.module

import com.github.kiolk.allmed.presentation.screen.tracker.adddrag.AddDragViewModel
import com.github.kiolk.allmed.presentation.screen.chat.ChatViewModel
import com.github.kiolk.allmed.presentation.screen.doctor.DoctorViewModel
import com.github.kiolk.allmed.presentation.screen.settings.SettingsViewModel
import com.github.kiolk.allmed.presentation.screen.splash.SplashViewModel
import com.github.kiolk.allmed.presentation.screen.tracker.TrackerViewModel
import com.github.kiolk.allmed.presentation.screen.tracker.day.DayViewModel
import com.github.kiolk.allmed.presentation.screen.tracker.details.DrugDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.*

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { ChatViewModel() }
    viewModel { SettingsViewModel() }
    viewModel { TrackerViewModel() }
    viewModel { DoctorViewModel() }
    viewModel { AddDragViewModel(get()) }
    viewModel { (date: Date) -> DayViewModel(get(), date) }
    viewModel { (patternId: Int) -> DrugDetailsViewModel(patternId) }
}