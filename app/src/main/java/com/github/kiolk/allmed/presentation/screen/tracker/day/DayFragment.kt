package com.github.kiolk.allmed.presentation.screen.tracker.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.base.BaseFragment
import com.github.kiolk.allmed.presentation.enums.DayOfWeek
import org.koin.androidx.viewmodel.ext.android.viewModel

class DayFragment : BaseFragment<DayViewModel>() {

    override val viewModel: DayViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(DAY_BUNDLE_KEY) }?.apply {
            val textView: TextView = view.findViewById(R.id.tw_title_day_fragment)
            textView.text = context?.getString(DayOfWeek.getString(this.getInt(DAY_BUNDLE_KEY)))
        }
    }

    companion object {
        const val DAY_BUNDLE_KEY = "DAY_BUNDLE_KEY"

        fun newInstance(day: Int): DayFragment {
            val fragment = DayFragment()
            val bundle = Bundle()
            bundle.apply {
                putInt(DAY_BUNDLE_KEY, day)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}