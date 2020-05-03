package com.github.kiolk.allmed.presentation.screen.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.base.BaseFragment
import com.github.kiolk.allmed.presentation.base.exstention.observeEvent
import com.github.kiolk.allmed.presentation.screen.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class Splash : BaseFragment<SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showTrackerScreenAction.observeEvent(viewLifecycleOwner) {
            this.findNavController().navigate(R.id.action_splash_to_trackerFragment)
            (activity as? MainActivity)?.findViewById<BottomNavigationView>(R.id.bottom_navigation)?.visibility = View.VISIBLE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}
