package com.hubx.myplant

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.hubx.myplant.databinding.ActivityMainBinding
import com.hubx.myplant.util.SharedPrefConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.seedDatabase()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val prefs = getSharedPreferences(SharedPrefConstants.SHARED_PREF_ONBOARDING, Context.MODE_PRIVATE)
        val isOnboardingCompleted = prefs.getBoolean(SharedPrefConstants.IS_ONBOARDING_SEEN, false)

        if (isOnboardingCompleted) {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(navController.graph.startDestinationId, true)
                .build()
            navController.navigate(R.id.main, null, navOptions)
        }
    }
}