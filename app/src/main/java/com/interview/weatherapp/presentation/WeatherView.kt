package com.interview.weatherapp.presentation

import androidx.lifecycle.MutableLiveData
import com.interview.weatherapp.core.UiState

interface WeatherView {

    val uiState: MutableLiveData<UiState?>
}