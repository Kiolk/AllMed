package com.github.kiolk.allmed.presentation.screen.tracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.data.datasource.drug.DefaultDrugRepository
import com.github.kiolk.allmed.data.datasource.drug.DragRepository
import com.github.kiolk.allmed.data.model.Drug
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import com.github.kiolk.allmed.presentation.base.viewModel.ActionLiveData
import com.github.kiolk.allmed.presentation.model.Event
import kotlinx.coroutines.launch
import java.util.*

class TrackerViewModel() : BaseViewModel() {

    private var _addDragAction: ActionLiveData<Event<Any>> = ActionLiveData()

    val addDragAction: LiveData<Event<Any>> = _addDragAction

    override fun onFirstAttached() {
        viewModelScope.launch {
//            drugRepository.saveDrug(
//                listOf(
//                    Drug(null, "Ibufen ${Random().nextInt()}"),
//                    Drug(null, "Ibufen ${Random().nextInt()}"),
//                    Drug(null, "Ibufen ${Random().nextInt()}"),
//                    Drug(null, "Ibufen ${Random().nextInt()}"),
//                    Drug(null, "Ibufen ${Random().nextInt()}"),
//                    Drug(null, "Ibufen ${Random().nextInt()}")
//                )
//            )
        }
    }

    fun onAddDragClicked() {
        _addDragAction.value = Event(Any())
    }
}