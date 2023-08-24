package com.interview.weatherapp.presentation.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.interview.weatherapp.presentation.model.Weather

class WeatherViewModel : ViewModel(), WeatherView {

    private val _weather: MutableLiveData<Weather?> = MutableLiveData()

    override val weather: LiveData<Weather?> = _weather

    fun setData(data: Weather?) {
        _weather.value = data
    }
}