package com.interview.weatherapp.presentation

import androidx.lifecycle.viewModelScope
import com.interview.weatherapp.data.exception.mapper.ErrorMapper
import com.interview.weatherapp.domain.weather.WeatherRepository
import com.interview.weatherapp.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel(
    private val repository: WeatherRepository,
    private val errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    fun fetchWeather() {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.getWeatherData(50.2944923, 18.6713802)
            }.onSuccess {
                println("WYNIKI= $it")
            }.onFailure {
                handleFailure(it)
            }
        }
    }
}