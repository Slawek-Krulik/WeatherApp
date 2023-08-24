package com.interview.weatherapp.data.remote.model

data class WeatherRemote(
    val current: Current?,
    val forecast: Forecast?,
    val location: Location?
)