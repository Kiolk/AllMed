package com.github.kiolk.allmed.presentation.screen.tracker.adddrag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.data.exstentions.toDDMMYYYY
import com.github.kiolk.allmed.domain.usecase.AddDragPatternUseCase
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import com.github.kiolk.allmed.presentation.base.viewModel.ActionLiveData
import com.github.kiolk.allmed.presentation.model.Event
import java.util.*

class AddDragViewModel(private val addDragPatternUseCase: AddDragPatternUseCase): BaseViewModel() {

    private var drug: String = ""

    private val _showStartDialog: ActionLiveData<Event<Any>> = ActionLiveData()
    private val _showEndDialog: ActionLiveData<Event<Any>> = ActionLiveData()
    private val _startDate: MutableLiveData<Date> = MutableLiveData()
    private val _endDate: MutableLiveData<Date> = MutableLiveData()

    val showStartDialog: LiveData<Event<Any>> = _showStartDialog
    val endStartDialog: LiveData<Event<Any>> = _showEndDialog

    val startDate: LiveData<String> = Transformations.map(_startDate) {
        it.toDDMMYYYY()
    }

    val endDate: LiveData<String> = Transformations.map(_endDate) {
        it.toDDMMYYYY()
    }

    fun saveDrugPattern(dragId: Int) {
        addDragPatternUseCase.invoke(viewModelScope, AddDragPatternUseCase.Params(drug, _startDate.value ?: Date(), _endDate.value ?: Date())){
            it.either(::onHandleError, ::onSavePatternSuccess)
        }
    }

    private fun onSavePatternSuccess(result: Boolean){
        onBackPressed()
    }

    fun onTextChanged(drug: String) {
        this.drug = drug
    }

    fun onFinishDateSelected(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        _endDate.value = Date(year, monthOfYear, dayOfMonth)
    }

    fun onStartDateSelected(pickedYear: Int, monthOfYear: Int, dayOfMonth: Int) {
        _startDate.value = Date(pickedYear, monthOfYear, dayOfMonth)
    }

    fun onStartClicked() {
        _showStartDialog.value = Event(Any())
    }

    fun onEndClicked() {
        _showEndDialog.value = Event(Any())
    }
}