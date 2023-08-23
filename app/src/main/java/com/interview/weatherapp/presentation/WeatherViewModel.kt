package com.interview.weatherapp.presentation

import androidx.lifecycle.ViewModel
import com.interview.weatherapp.domain.location.LocationTracker
import com.interview.weatherapp.domain.weather.WeatherRepository

class WeatherViewModel(
    private val repository: WeatherRepository,
    private val currentLocation: LocationTracker
): ViewModel() {


}