package com.github.kiolk.allmed.presentation.screen.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.data.datasource.drug.DragRepository
import com.github.kiolk.allmed.presentation.adapter.doctor.amoksiklav
import com.github.kiolk.allmed.presentation.adapter.doctor.analgin
import com.github.kiolk.allmed.presentation.adapter.doctor.boyaryshnik
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import com.github.kiolk.allmed.presentation.base.viewModel.ActionLiveData
import com.github.kiolk.allmed.presentation.model.Event
import kotlinx.coroutines.launch

class SplashViewModel(private val drugRepository: DragRepository) : BaseViewModel() {

    private val _showTrackerScreenAction: ActionLiveData<Event<Any>> = ActionLiveData()

    val showTrackerScreenAction: LiveData<Event<Any>> = _showTrackerScreenAction

    override fun onFirstAttached() {
        viewModelScope.launch {
            drugRepository.saveDrug(
                listOf(amoksiklav, analgin, boyaryshnik)
            )
            _showTrackerScreenAction.value = Event(Any())
        }
    }
}