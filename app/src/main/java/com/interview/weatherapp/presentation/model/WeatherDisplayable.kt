package com.interview.weatherapp.presentation.model

import com.interview.weatherapp.domain.weather.model.WeatherDay

data class WeatherDisplayable(
    val firstDay: List<WeatherDay>
)
