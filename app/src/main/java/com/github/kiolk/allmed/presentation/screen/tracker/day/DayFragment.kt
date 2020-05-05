package com.github.kiolk.allmed.presentation.screen.tracker.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.day.DayDrugAdapter
import com.github.kiolk.allmed.presentation.base.BaseFragment
import com.github.kiolk.allmed.presentation.base.exstention.observeEvent
import com.github.kiolk.allmed.presentation.base.exstention.observeNotNull
import kotlinx.android.synthetic.main.fragment_day.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.*

class DayFragment : BaseFragment<DayViewModel>() {

    override val viewModel: DayViewModel by viewModel {
        parametersOf(
            arguments?.getSerializable(
                DATE_BUNDLE_KEY
            ) as Date
        )
    }

    private lateinit var adapter: DayDrugAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel.onFirstAttached()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = DayDrugAdapter() {
            viewModel.onAcceptanceClicked(it.acceptance)
        }
        rv_day_drug_list.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_day_drug_list.adapter = adapter

        btn_diagnostic.setOnClickListener {
            findNavController().navigate(R.id.action_tracker_fragment_to_diagnosticFragment)
        }

        viewModel.data.observeNotNull(viewLifecycleOwner) {
            adapter.addALl(it)
        }

        viewModel.selectDate.observeNotNull(viewLifecycleOwner){
            tv_day_track.text = it
        }

        viewModel.openDrugPatternDetails.observeEvent(viewLifecycleOwner) {
            findNavController().navigate(
                R.id.action_tracker_fragment_to_drugDetailsFragment,
                Bundle().apply {
                    putInt(
                        DRUG_PATTERN_ID_BUNDLE_KEY, it
                    )
                })
        }
    }

    companion object {
        const val DAY_BUNDLE_KEY = "DAY_BUNDLE_KEY"
        const val DATE_BUNDLE_KEY = "DATE_BUNDLE_KEY"
        const val DRUG_PATTERN_ID_BUNDLE_KEY = "DRUG_PATTERN_ID_BUNDLE_KEY"

        fun newInstance(day: Int, date: Date): DayFragment {
            val fragment = DayFragment()
            val bundle = Bundle()
            bundle.apply {
                putInt(DAY_BUNDLE_KEY, day)
                putSerializable(DATE_BUNDLE_KEY, date)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}