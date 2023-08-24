package com.interview.weatherapp.presentation.fragment

import androidx.lifecycle.LiveData
import com.interview.weatherapp.domain.weather.model.Weather

interface WeatherView {
    val weather: LiveData<Weather?>
}