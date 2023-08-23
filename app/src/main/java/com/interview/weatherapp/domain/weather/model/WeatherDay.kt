package com.interview.weatherapp.domain.weather.model

import com.interview.weatherapp.presentation.model.Icon

data class WeatherDay(
    val minTemperature: Double,
    val maxTemperature: Double,
    val avgTemperature: Double,
    val avgHumidity: Double,
    val icon: Icon
)
