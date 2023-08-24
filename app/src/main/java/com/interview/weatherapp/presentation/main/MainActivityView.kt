package com.interview.weatherapp.presentation.main

import androidx.lifecycle.LiveData
import com.interview.weatherapp.core.UiState
import com.interview.weatherapp.presentation.model.Weather

interface MainActivityView {

    val uiState: LiveData<UiState?>

    val items: LiveData<List<Weather?>>
}