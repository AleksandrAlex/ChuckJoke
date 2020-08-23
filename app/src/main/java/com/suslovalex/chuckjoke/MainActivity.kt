package com.suslovalex.chuckjoke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBar()
    }

    private fun setupActionBar() {
        val bottomNav = bottom_navigation
        val navController = findNavController(R.id.fragment)
        val appBarConf = AppBarConfiguration(setOf(R.id.jokeFragment,R.id.infoFragment))
        setupActionBarWithNavController(navController, appBarConf)
        bottomNav.setupWithNavController(navController)
    }
}