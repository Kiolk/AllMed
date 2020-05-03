package com.github.kiolk.allmed.presentation.screen.tracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.TrackFragmentAdapter
import com.github.kiolk.allmed.presentation.base.BaseFragment
import com.github.kiolk.allmed.presentation.base.exstention.observeEvent
import kotlinx.android.synthetic.main.fragment_tracker.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrackerFragment : BaseFragment<TrackerViewModel>() {

    override val viewModel: TrackerViewModel by viewModel()

    private lateinit var adapter: TrackFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tracker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TrackFragmentAdapter(requireContext(), requireFragmentManager())
        vp_tracker_pager.adapter = adapter

        fab_add_drag.setOnClickListener {
            viewModel.onAddDragClicked()
        }

        viewModel.addDragAction.observeEvent(viewLifecycleOwner){
            findNavController().navigate(R.id.action_tracker_fragment_to_addDragFragment)
        }
    }
}
