package com.github.kiolk.allmed.presentation.screen.adddrag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.base.BaseFragment
import com.github.kiolk.allmed.presentation.base.exstention.observeEvent
import kotlinx.android.synthetic.main.fragment_add_drag.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddDragFragment : BaseFragment<AddDragViewModel>(){

    override val viewModel: AddDragViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_drag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tb_add_drag.setNavigationOnClickListener {
            viewModel.onBackPressed()
        }

        btn_save_drug_pattern.setOnClickListener {
            viewModel.saveDrugPattern(1)
        }

        viewModel.onNavigateBack.observeEvent(viewLifecycleOwner){
            findNavController().popBackStack()
        }
    }
}
