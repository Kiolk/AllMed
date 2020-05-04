package com.github.kiolk.allmed.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM> : Fragment() where VM : BaseViewModel {

    abstract val viewModel: VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.onFirstAttached()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewBounded()
    }

    protected fun stubDialog() {
        val builder: AlertDialog.Builder? = activity?.let {
            AlertDialog.Builder(it)
        }

        builder?.setMessage("¯\\_(ツ)_/¯")
            ?.setTitle("Эта функциональность еще не реализована")
            ?.setPositiveButton("Да, я понимаю") { _, _ -> }

        builder?.create()?.show()
    }
}