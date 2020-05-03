package com.github.kiolk.allmed.presentation.screen.tracker.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.day.DayDrugAdapter
import com.github.kiolk.allmed.presentation.base.BaseFragment
import com.github.kiolk.allmed.presentation.base.exstention.observeNotNull
import com.github.kiolk.allmed.presentation.enums.DayOfWeek
import kotlinx.android.synthetic.main.fragment_day.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.*

class DayFragment : BaseFragment<DayViewModel>() {

    override val viewModel: DayViewModel by viewModel{ parametersOf(arguments?.getSerializable(
        DATE_BUNDLE_KEY) as Date)}

    private lateinit var adapter: DayDrugAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = DayDrugAdapter()
        rv_day_drug_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_day_drug_list.adapter = adapter

        viewModel.data.observeNotNull(viewLifecycleOwner){
            adapter.addALl(it)
        }

        arguments?.takeIf { it.containsKey(DAY_BUNDLE_KEY) }?.apply {
            val textView: TextView = view.findViewById(R.id.tw_title_day_fragment)
            textView.text = context?.getString(DayOfWeek.getString(this.getInt(DAY_BUNDLE_KEY)))
        }
    }

    companion object {
        const val DAY_BUNDLE_KEY = "DAY_BUNDLE_KEY"
        const val DATE_BUNDLE_KEY = "DATE_BUNDLE_KEY"

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