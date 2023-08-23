package com.interview.weatherapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.interview.weatherapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchWeather()
    }
}