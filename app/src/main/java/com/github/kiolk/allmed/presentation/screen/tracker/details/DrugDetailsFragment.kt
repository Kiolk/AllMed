package com.github.kiolk.allmed.presentation.screen.tracker.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.base.BaseFragment
import com.github.kiolk.allmed.presentation.base.exstention.observeEvent
import com.github.kiolk.allmed.presentation.screen.tracker.day.DayFragment
import kotlinx.android.synthetic.main.fragment_drug_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DrugDetailsFragment : BaseFragment<DrugDetailsViewModel>() {

    override val viewModel: DrugDetailsViewModel by viewModel {
        parametersOf(
            arguments?.getInt(
                DayFragment.DRUG_PATTERN_ID_BUNDLE_KEY
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drug_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_acceptance_details_back.setOnClickListener {
            viewModel.onBackPressed()
        }

        viewModel.onNavigateBack.observeEvent(viewLifecycleOwner){
            findNavController().popBackStack()
        }
    }
}
