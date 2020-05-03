package com.github.kiolk.allmed.presentation.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.kiolk.allmed.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setupWithNavController(
            findNavController(this, R.id.nav_host_fragment)
        )
        setupNavigation()
    }

    private fun setupNavigation() {
        findNavController(
            this,
            R.id.nav_host_fragment
        ).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.addDragFragment -> showBottomNavigation(false)
                R.id.splash -> showBottomNavigation(false)
                else  -> showBottomNavigation(true)
            }
        }
    }

    private fun showBottomNavigation(isShow: Boolean) {
        if (isShow) {
            bottom_navigation.visibility = View.VISIBLE
        } else {
            bottom_navigation.visibility = View.GONE
        }
    }
}
