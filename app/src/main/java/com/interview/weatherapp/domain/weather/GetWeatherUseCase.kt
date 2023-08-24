package com.interview.weatherapp.domain.weather

import com.interview.weatherapp.core.BaseUseCase
import com.interview.weatherapp.domain.location.model.Location
import com.interview.weatherapp.presentation.model.Weather
import com.interview.weatherapp.domain.weather.repository.WeatherRepository

class GetWeatherUseCase(
    private val repository: WeatherRepository,
    private val dateConverter: DateConverter
): BaseUseCase<List<Weather?>, Pair<Int, Location>>() {
    override suspend fun action(params: Pair<Int, Location>): List<Weather?> {
        val (days, location) = params
        val weathers = repository.getWeatherData(location, days)
        return weathers.map { it?.copy(date = dateConverter.convert(it.date)) }
    }
}