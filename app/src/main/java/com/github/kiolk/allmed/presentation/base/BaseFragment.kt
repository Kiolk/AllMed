package com.github.kiolk.allmed.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM>: Fragment() where VM: BaseViewModel{

    abstract val viewModel: VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.onFirstAttached()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewBounded()
    }
}