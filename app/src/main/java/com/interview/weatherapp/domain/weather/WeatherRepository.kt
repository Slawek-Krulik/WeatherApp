package com.interview.weatherapp.domain.weather

import com.interview.weatherapp.data.remote.dto.WeatherRemote

interface WeatherRepository {

    suspend fun getWeatherData(latitude: Double, longitude: Double): WeatherRemote
}