package com.github.kiolk.allmed.presentation.screen.tracker

import androidx.lifecycle.LiveData
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import com.github.kiolk.allmed.presentation.base.viewModel.ActionLiveData
import com.github.kiolk.allmed.presentation.model.Event

class TrackerViewModel: BaseViewModel() {

    private var _addDragAction: ActionLiveData<Event<Any>> = ActionLiveData()

    val addDragAction: LiveData<Event<Any>> = _addDragAction

    fun onAddDragClicked() {
        _addDragAction.value = Event(Any())
    }
}