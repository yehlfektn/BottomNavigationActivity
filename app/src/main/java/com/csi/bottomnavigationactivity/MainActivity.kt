package com.csi.bottomnavigationactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.csi.bottomnavigationactivity.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("OnCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onStart() = super.onStart().also { Timber.i("OnStart()") }

    override fun onResume() = super.onResume().also { Timber.i("OnResume()") }

    override fun onPause() = super.onPause().also { Timber.i("onPause()") }

    override fun onStop() = super.onStop().also { Timber.i("onStop()") }

    override fun onRestart() = super.onRestart().also { Timber.i("onRestart()") }

    override fun onDestroy() = super.onDestroy().also { Timber.e("onDestroy()") }

}