package com.interview.weatherapp.domain.weather

interface WeatherRepository {

    suspend fun getWeatherData()
}