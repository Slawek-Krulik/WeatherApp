package com.interview.weatherapp.presentation.model

import com.interview.weatherapp.domain.weather.model.Weather

data class WeatherDisplayable(
    val firstDay: List<Weather>
)
