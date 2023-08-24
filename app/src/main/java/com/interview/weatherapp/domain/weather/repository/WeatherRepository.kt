package com.interview.weatherapp.domain.weather.repository

import com.interview.weatherapp.domain.location.model.Location
import com.interview.weatherapp.presentation.model.Weather

interface WeatherRepository {

    suspend fun getWeatherData(location: Location?, days: Int): List<Weather?>
}