package com.interview.weatherapp.presentation.main

import android.os.Bundle
import androidx.core.os.bundleOf
import com.interview.weatherapp.R
import com.interview.weatherapp.core.BaseActivity
import com.interview.weatherapp.databinding.ActivityMainBinding
import com.interview.weatherapp.presentation.fragment.WEATHER_EXTRA
import com.interview.weatherapp.presentation.fragment.WeatherFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.viewModel = viewModel
        initObservers()
    }

    private fun initObservers() {
        viewModel.startFragmentEvent.observe { weather ->
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, WeatherFragment().apply { arguments = bundleOf(WEATHER_EXTRA to weather) })
                commit()
            }
        }
    }

}