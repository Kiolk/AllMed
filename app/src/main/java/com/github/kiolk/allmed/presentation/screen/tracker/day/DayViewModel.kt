package com.github.kiolk.allmed.presentation.screen.tracker.day

import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.domain.usecase.GetAcceptanceUseCase
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import timber.log.Timber
import java.util.*

class DayViewModel(private val getAcceptanceUseCase: GetAcceptanceUseCase): BaseViewModel() {

    override fun onFirstAttached() {
        getAcceptanceUseCase.invoke(viewModelScope, GetAcceptanceUseCase.Params(Date())){
            it.either(::onHandleError, ::onSuccessFetchAcceptances)
        }
    }

    private fun onSuccessFetchAcceptances(acceptances: List<Acceptance>) {
        acceptances.forEach {
            Timber.e(it.toString())
        }
    }
}