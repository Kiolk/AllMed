package com.github.kiolk.allmed.presentation.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    open fun onFirstAttached() { }

    open fun onViewBounded() { }
}