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

    private var isFirst = true

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
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
                R.id.drugDetailsFragment -> showBottomNavigation(false)
                R.id.diagnosticFragment -> showBottomNavigation(false)
                R.id.splash -> {
                    if(isFirst){
                        showBottomNavigation(false)
                    }else {
                        onBackPressed()
                    }
                }
                else  -> {
                    showBottomNavigation(true)
                    isFirst = false
                }
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
