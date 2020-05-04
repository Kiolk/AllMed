package com.github.kiolk.allmed.presentation.screen.tracker.day

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.FullAcceptance
import com.github.kiolk.allmed.domain.usecase.GetAcceptanceUseCase
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import com.github.kiolk.allmed.presentation.base.viewModel.ActionLiveData
import com.github.kiolk.allmed.presentation.model.Event
import timber.log.Timber
import java.util.*

class DayViewModel(
    private val getAcceptanceUseCase: GetAcceptanceUseCase,
    private val date: Date
) : BaseViewModel() {

    private val _data: MutableLiveData<List<FullAcceptance>> = MutableLiveData()
    private val _openDrugPatternDetails: ActionLiveData<Event<Int>> = ActionLiveData<Event<Int>>()

    val data: LiveData<List<FullAcceptance>> = _data
    val openDrugPatternDetails: LiveData<Event<Int>> = _openDrugPatternDetails

    override fun onFirstAttached() {
        getAcceptanceUseCase.invoke(viewModelScope, GetAcceptanceUseCase.Params(date)) {
            it.either(::onHandleError, ::onSuccessFetchAcceptances)
        }
    }

    private fun onSuccessFetchAcceptances(acceptances: List<FullAcceptance>) {
        _data.value = acceptances
        acceptances.forEach {
            Timber.e(it.toString())
        }
    }

    fun onAcceptanceClicked(acceptance: Acceptance) {
        _openDrugPatternDetails.value = Event(acceptance.patternId)
    }
}