package com.github.kiolk.allmed.presentation.screen.diagnostic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.diagnostic.DiagnosticAdapter
import com.github.kiolk.allmed.presentation.adapter.doctor.canceled
import com.github.kiolk.allmed.presentation.adapter.doctor.completedDiagnostic
import com.github.kiolk.allmed.presentation.adapter.doctor.scheduledDiagnostic
import com.github.kiolk.allmed.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_diagnostic.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiagnosticFragment : BaseFragment<DiagnosticViewModel>() {

    override val viewModel: DiagnosticViewModel by viewModel()

    private lateinit var adapter: DiagnosticAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diagnostic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = DiagnosticAdapter()
        rv_diagnostic_time_table.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_diagnostic_time_table.adapter = adapter


        btn_diagnostic_back.setOnClickListener {
            findNavController().popBackStack()
        }

        btn_diagnostic_scheduled.setOnClickListener {
            resetButtons()
            btn_diagnostic_scheduled.background = context?.getDrawable(R.drawable.bg_right_side_button_selected)
            adapter.addALl(scheduledDiagnostic)
        }

        btn_diagnostic_completed.setOnClickListener {
            resetButtons()
            btn_diagnostic_completed.background = context?.getDrawable(R.drawable.bg_right_side_button_selected)
            adapter.addALl(completedDiagnostic)
        }

        btn_diagnostic_canceled.setOnClickListener {
            resetButtons()
            btn_diagnostic_canceled.background = context?.getDrawable(R.drawable.bg_right_side_button_selected)
            adapter.addALl(canceled)
        }

        resetButtons()
        btn_diagnostic_scheduled.background = context?.getDrawable(R.drawable.bg_right_side_button_selected)
        adapter.addALl(scheduledDiagnostic)
    }

    private fun resetButtons(){
        btn_diagnostic_canceled.background = context?.getDrawable(R.drawable.bg_right_side_button)
        btn_diagnostic_scheduled.background = context?.getDrawable(R.drawable.bg_right_side_button)
        btn_diagnostic_completed.background = context?.getDrawable(R.drawable.bg_right_side_button)
    }
}
