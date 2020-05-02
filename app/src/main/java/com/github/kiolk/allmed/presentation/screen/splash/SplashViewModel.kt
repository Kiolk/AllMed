package com.github.kiolk.allmed.presentation.screen.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import com.github.kiolk.allmed.presentation.base.viewModel.ActionLiveData
import com.github.kiolk.allmed.presentation.model.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: BaseViewModel() {

    private val _showTrackerScreenAction: ActionLiveData<Event<Any>> = ActionLiveData()

    val showTrackerScreenAction: LiveData<Event<Any>> = _showTrackerScreenAction

    override fun onFirstAttached() {
        viewModelScope.launch {
            delay(3000)
            _showTrackerScreenAction.value = Event(Any())
        }
    }
}