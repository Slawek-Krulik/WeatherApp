package com.interview.weatherapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.interview.weatherapp.core.BaseViewModel
import com.interview.weatherapp.core.UiState
import com.interview.weatherapp.data.exception.mapper.ErrorMapper
import com.interview.weatherapp.domain.location.LocationTracker
import com.interview.weatherapp.domain.weather.GetWeatherUseCase
import com.interview.weatherapp.domain.weather.model.Weather
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val locationTracker: LocationTracker,
    private val errorMapper: ErrorMapper
) : BaseViewModel(errorMapper), WeatherView {

    private val _uiState by lazy { MutableLiveData<UiState>(UiState.Idle) }

    override val uiState: LiveData<UiState?> = _uiState

    private val _weather by lazy {
        MutableLiveData<List<Weather?>?>()
            .also { fetchWeather(it) }
    }

    override val weather: LiveData<List<Weather?>?> by lazy { _weather }

    private fun fetchWeather(weatherLiveData: MutableLiveData<List<Weather?>?>) {
        _uiState.value = UiState.Pending
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.also { location ->
                getWeatherUseCase(
                    params = 3 to location,
                    scope = viewModelScope
                ) { result ->
                    result.onSuccess { weatherLiveData.value = it }
                    result.onFailure { handleFailure(it) }
                    _uiState.value = UiState.Idle
                }
            }
        }
    }
}