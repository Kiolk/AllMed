package com.github.kiolk.allmed.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.github.kiolk.allmed.presentation.base.viewModel.ActionLiveData
import com.github.kiolk.allmed.presentation.model.Event

abstract class BaseViewModel: ViewModel() {

    private val _onNavigateBack: ActionLiveData<Event<Any>> = ActionLiveData()

    val onNavigateBack: LiveData<Event<Any>> = _onNavigateBack

    open fun onFirstAttached() { }

    open fun onViewBounded() { }

    open fun onBackPressed() {
        _onNavigateBack.value = Event(Any())
    }
}