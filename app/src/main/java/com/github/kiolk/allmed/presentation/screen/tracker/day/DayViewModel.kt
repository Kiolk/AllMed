package com.github.kiolk.allmed.presentation.screen.tracker.day

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.domain.usecase.GetAcceptanceUseCase
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import timber.log.Timber
import java.util.*

class DayViewModel(
    private val getAcceptanceUseCase: GetAcceptanceUseCase,
    private val date: Date
) : BaseViewModel() {

    private val _data: MutableLiveData<List<Acceptance>> = MutableLiveData()

    val data: LiveData<List<Acceptance>> = _data

    override fun onFirstAttached() {
        getAcceptanceUseCase.invoke(viewModelScope, GetAcceptanceUseCase.Params(date)) {
            it.either(::onHandleError, ::onSuccessFetchAcceptances)
        }
    }

    private fun onSuccessFetchAcceptances(acceptances: List<Acceptance>) {
        _data.value = acceptances
        acceptances.forEach {
            Timber.e(it.toString())
        }
    }
}