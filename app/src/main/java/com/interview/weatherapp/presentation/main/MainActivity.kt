package com.interview.weatherapp.presentation.main

import android.os.Bundle
import com.interview.weatherapp.R
import com.interview.weatherapp.core.BaseActivity
import com.interview.weatherapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.viewModel = viewModel
    }
}