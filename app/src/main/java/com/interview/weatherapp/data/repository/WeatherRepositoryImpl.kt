package com.interview.weatherapp.data.repository

import com.interview.weatherapp.data.exception.wrapper.ErrorWrapper
import com.interview.weatherapp.data.exception.wrapper.callOrThrow
import com.interview.weatherapp.data.remote.WeatherApi
import com.interview.weatherapp.domain.location.model.Location
import com.interview.weatherapp.domain.weather.WeatherRepository
import com.interview.weatherapp.domain.weather.model.Weather

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val errorWrapper: ErrorWrapper
) : WeatherRepository {
    override suspend fun getWeatherData(location: Location?): Weather {

        return callOrThrow(errorWrapper) { api.getWeatherData("${location?.latitude},${location?.longitude}").toWeather() }
    }
}