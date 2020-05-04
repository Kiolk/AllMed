package com.github.kiolk.allmed.presentation.screen.tracker.adddrag

import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.domain.usecase.AddDragPatternUseCase
import com.github.kiolk.allmed.presentation.base.BaseViewModel

class AddDragViewModel(private val addDragPatternUseCase: AddDragPatternUseCase): BaseViewModel() {

    fun saveDrugPattern(dragId: Int) {
        addDragPatternUseCase.invoke(viewModelScope, AddDragPatternUseCase.Params()){
            it.either(::onHandleError, ::onSavePatternSuccess)
        }
    }

    private fun onSavePatternSuccess(result: Boolean){
        onBackPressed()
    }
}