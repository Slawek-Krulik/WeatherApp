package com.interview.weatherapp.data.repository

import com.interview.weatherapp.data.exception.wrapper.ErrorWrapper
import com.interview.weatherapp.data.exception.wrapper.callOrThrow
import com.interview.weatherapp.data.remote.WeatherApi
import com.interview.weatherapp.domain.location.model.Location
import com.interview.weatherapp.domain.weather.repository.WeatherRepository
import com.interview.weatherapp.domain.weather.model.Weather

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val errorWrapper: ErrorWrapper
) : WeatherRepository {
    override suspend fun getWeatherData(location: Location?, days: Int): List<Weather?>  {

        return callOrThrow(errorWrapper) {
            api.getWeatherData(
                coordinates = "${location?.latitude},${location?.longitude}",
                days = days)
                .forecast?.forecastday
                ?.map { Weather(it.day?.toWeather()).copy(date = it.date) } ?: emptyList()
        }
    }
}