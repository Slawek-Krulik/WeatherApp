package com.interview.weatherapp.data.repository

import com.interview.weatherapp.data.exception.wrapper.ErrorWrapper
import com.interview.weatherapp.data.exception.wrapper.callOrThrow
import com.interview.weatherapp.data.remote.WeatherApi
import com.interview.weatherapp.domain.location.model.Location
import com.interview.weatherapp.domain.weather.model.Weather
import com.interview.weatherapp.domain.weather.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val errorWrapper: ErrorWrapper
) : WeatherRepository {
    override suspend fun getWeatherData(location: Location?, days: Int): List<Weather?> {

        val result = callOrThrow(errorWrapper) {
            api.getWeatherData(
                coordinates = "${location?.latitude},${location?.longitude}",
                days = days
            )
        }
        val city = result.location?.name
        return result.forecast?.forecastday
            ?.map { Weather(it.day?.toWeather()).copy(date = it.date, city = city) } ?: emptyList()
    }

}