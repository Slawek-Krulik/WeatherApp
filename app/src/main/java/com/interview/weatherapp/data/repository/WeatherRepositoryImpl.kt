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
    private val errorWrapper: ErrorWrapper,
    private val dataFormatterValidator: DataFormatterValidator
) : WeatherRepository {
    override suspend fun getWeatherData(location: Location?): List<WeatherDay?>  {

        return callOrThrow(errorWrapper) {
            api.getWeatherData("${location?.latitude},${location?.longitude}")
                .forecast.forecastDay
                ?.filter { dataFormatterValidator.isDateOnlyFormat(it?.date) }
                ?.map { it?.day?.toWeather() } ?: emptyList()
        }
    }
}