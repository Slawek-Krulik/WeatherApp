package com.interview.weatherapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.interview.weatherapp.core.BaseViewModel
import com.interview.weatherapp.core.UiState
import com.interview.weatherapp.data.exception.mapper.ErrorMapper
import com.interview.weatherapp.domain.weather.WeatherRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository,
    private val errorMapper: ErrorMapper
) : BaseViewModel(errorMapper), WeatherView {

    override val uiState: MutableLiveData<UiState?> = MutableLiveData(UiState.Pending)
    fun fetchWeather() {
        setPendingState()//
        uiState.value = UiState.Pending
        viewModelScope.launch {
            delay(3000)
            kotlin.runCatching {
                repository.getWeatherData(50.2944923, 18.6713802)
            }.onSuccess {
                uiState.value = UiState.Idle

                println("WYNIKI= $it")
            }.onFailure {
                handleFailure(it)
            }
        }
    }
}