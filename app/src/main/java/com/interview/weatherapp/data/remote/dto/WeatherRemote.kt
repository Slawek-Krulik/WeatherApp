package com.interview.weatherapp.data.remote.dto

import com.interview.weatherapp.domain.weather.model.Weather

data class WeatherRemote(
    val current: Current,
    val location: Location
){

    fun toWeather() = Weather(
        temperature = current.temp_c,
        humidity = current.humidity
    )
}