package com.interview.weatherapp.data.repository

import com.interview.weatherapp.data.exception.wrapper.ErrorWrapper
import com.interview.weatherapp.data.remote.WeatherApi
import com.interview.weatherapp.data.remote.dto.WeatherRemote
import com.interview.weatherapp.domain.weather.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val errorWrapper: ErrorWrapper
) : WeatherRepository {
    override suspend fun getWeatherData(latitude: Double, longitude: Double): WeatherRemote {

        return api.getWeatherData("$latitude,$longitude")
    }
}