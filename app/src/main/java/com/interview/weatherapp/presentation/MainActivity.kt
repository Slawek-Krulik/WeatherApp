package com.interview.weatherapp.presentation

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.interview.weatherapp.core.BaseActivity
import com.interview.weatherapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initObservers()
    }

    private fun initBinding() {
        binding.let {
            it.lifecycleOwner = this@MainActivity
            it.viewModel = viewModel
        }
    }

    private fun initObservers() {
        viewModel.message.observe(this) { showSnackbar(it) }
        viewModel.data.observe(this) {  }
    }

}