package com.interview.weatherapp.domain.weather

import com.interview.weatherapp.domain.location.model.Location
import com.interview.weatherapp.domain.weather.model.WeatherDay

interface WeatherRepository {

    suspend fun getWeatherData(location: Location?, days: Int): List<WeatherDay?>
}