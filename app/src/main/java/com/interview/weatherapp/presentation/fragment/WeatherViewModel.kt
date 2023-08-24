package com.interview.weatherapp.presentation.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.interview.weatherapp.domain.weather.model.Weather

class WeatherViewModel : ViewModel(), WeatherView {

    override val weather: LiveData<Weather?> = MutableLiveData()
}