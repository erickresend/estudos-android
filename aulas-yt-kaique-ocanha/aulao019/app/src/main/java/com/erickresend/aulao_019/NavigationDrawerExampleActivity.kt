package com.erickresend.aulao_019

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.erickresend.aulao_019.databinding.ActivityNavigationDrawerExampleBinding

class NavigationDrawerExampleActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityNavigationDrawerExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNavigationDrawerExampleBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val navHostFragment = (supportFragmentManager.findFragmentById(_binding.fragmentContainerView2.id)) as NavHostFragment
        val navController = navHostFragment.navController
        _binding.navView.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(navController.graph, _binding.drawerlayout)
        _binding.toolbar2.setupWithNavController(navController, appBarConfiguration)
    }
}