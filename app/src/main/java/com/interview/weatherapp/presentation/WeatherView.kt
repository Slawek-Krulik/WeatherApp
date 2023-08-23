package com.interview.weatherapp.presentation

import androidx.lifecycle.LiveData
import com.interview.weatherapp.core.UiState
import com.interview.weatherapp.domain.weather.model.WeatherDay

interface WeatherView {

    val uiState: LiveData<UiState?>

    val data: LiveData<List<WeatherDay?>?>
}