package com.interview.weatherapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.interview.weatherapp.core.BaseViewModel
import com.interview.weatherapp.core.UiState
import com.interview.weatherapp.data.exception.mapper.ErrorMapper
import com.interview.weatherapp.domain.location.LocationTracker
import com.interview.weatherapp.domain.weather.WeatherRepository
import com.interview.weatherapp.domain.weather.model.Weather
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
    private val errorMapper: ErrorMapper
) : BaseViewModel(errorMapper), WeatherView {

    private val _uiState by lazy { MutableLiveData<UiState>(UiState.Idle) }

    override val uiState: LiveData<UiState?> = _uiState

    private val _weather by lazy {
        MutableLiveData<Weather>()
            .also { fetchWeather(it) }
    }

    override val data: LiveData<Weather?> by lazy { _weather }

    private fun fetchWeather(weatherLiveData: MutableLiveData<Weather>) {
        _uiState.value = UiState.Pending
        viewModelScope.launch {
            delay(2500)
            kotlin.runCatching {
                val currentLocation = locationTracker.getCurrentLocation()
                if (currentLocation != null) repository.getWeatherData(currentLocation) else null
            }.onSuccess {
                weatherLiveData.value = it
            }.onFailure {
                handleFailure(it)
            }.also {
                _uiState.value = UiState.Idle
            }
        }
    }
}