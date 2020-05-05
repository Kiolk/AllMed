package com.github.kiolk.allmed.presentation.screen.tracker.adddrag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.base.BaseFragment
import com.github.kiolk.allmed.presentation.base.exstention.observeEvent
import com.github.kiolk.allmed.presentation.base.exstention.observeNotNull
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.fragment_add_drag.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class AddDragFragment : BaseFragment<AddDragViewModel>() {

    override val viewModel: AddDragViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_drag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_add_drug_back.setOnClickListener {
            viewModel.onBackPressed()
        }

        btn_save_drug_pattern.setOnClickListener {
            viewModel.saveDrugPattern(1)
        }

        viewModel.onNavigateBack.observeEvent(viewLifecycleOwner) {
            findNavController().popBackStack()
        }

        et_add_drug_name.addTextChangedListener {
            viewModel.onTextChanged(it.toString())
        }

        btn_start_drug_period.setOnClickListener {
            viewModel.onStartClicked()
        }

        btn_end_drug_period.setOnClickListener {
            viewModel.onEndClicked()
        }

        viewModel.showStartDialog.observeEvent(viewLifecycleOwner) {
            showStartDateDialog(Array<Calendar>(0) { Calendar.getInstance() })
        }

        viewModel.endStartDialog.observeEvent(viewLifecycleOwner) {
            showEndDateDialog()
        }

        viewModel.startDate.observeNotNull(viewLifecycleOwner) {
            tv_start_drug_title.text = it
        }

        viewModel.endDate.observeNotNull(viewLifecycleOwner) {
            tv_end_drug_title.text = it
        }
    }

    private fun showStartDateDialog(disableDays: Array<Calendar>) {
        val startDate = Calendar.getInstance()
        val year = startDate.get(Calendar.YEAR)
        val month = startDate.get(Calendar.MONTH)
        val day = startDate.get(Calendar.DAY_OF_MONTH)

        val dpd: DatePickerDialog =
            DatePickerDialog.newInstance({ _, pickedYear, monthOfYear, dayOfMonth ->
                viewModel.onStartDateSelected(pickedYear, monthOfYear, dayOfMonth)
            }, year, month, day)

        dpd.minDate = startDate
        dpd.showYearPickerFirst(false)
        dpd.setTitle(getString(R.string.start_date_title))
        dpd.disabledDays = disableDays
        dpd.show(childFragmentManager, "START")
    }

    private fun showEndDateDialog() {
//    private fun showEndDateDialog(minDate: Calendar, maxDate: Calendar) {
        val endDate = Calendar.getInstance()
        val yearE = endDate.get(Calendar.YEAR)
        val monthE = endDate.get(Calendar.MONTH)
        val dayE = endDate.get(Calendar.DAY_OF_MONTH)

        val dpd: DatePickerDialog =
            DatePickerDialog.newInstance({ _, year, monthOfYear, dayOfMonth ->
                viewModel.onFinishDateSelected(year, monthOfYear, dayOfMonth)
            }, yearE, monthE, dayE)

//        dpd.minDate = minDate
//        dpd.maxDate = maxDate
        dpd.showYearPickerFirst(false)
        dpd.setTitle(getString(R.string.end_date_title))
        dpd.show(childFragmentManager, "END")
    }
}
