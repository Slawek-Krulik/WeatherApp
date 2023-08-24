package com.interview.weatherapp.data.repository

import com.interview.weatherapp.core.DataFormatterValidator
import com.interview.weatherapp.data.exception.wrapper.ErrorWrapper
import com.interview.weatherapp.data.exception.wrapper.callOrThrow
import com.interview.weatherapp.data.remote.WeatherApi
import com.interview.weatherapp.domain.location.model.Location
import com.interview.weatherapp.domain.weather.WeatherRepository
import com.interview.weatherapp.domain.weather.model.WeatherDay

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val errorWrapper: ErrorWrapper
) : WeatherRepository {
    override suspend fun getWeatherData(location: Location?, days: Int): List<WeatherDay?>  {

        return callOrThrow(errorWrapper) {
            api.getWeatherData(
                coordinates = "${location?.latitude},${location?.longitude}",
                days = days)
                .forecast?.forecastday
                ?.map { it.day?.toWeather() } ?: emptyList()
        }
    }
}