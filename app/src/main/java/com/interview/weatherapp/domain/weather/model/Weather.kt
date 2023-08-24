package com.interview.weatherapp.domain.weather.model

import com.interview.weatherapp.presentation.model.Icon

data class Weather(
    val date: String? = "",
    val temperature: Double?,
    val humidity: Double?,
    val icon: Icon?
) {
    constructor(weather: Weather?) : this(
        temperature = weather?.temperature,
        humidity = weather?.humidity,
        icon = weather?.icon
    )
}
