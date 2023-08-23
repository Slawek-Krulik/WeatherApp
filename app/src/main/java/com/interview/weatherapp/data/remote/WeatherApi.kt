package com.interview.weatherapp.data.remote

import com.interview.weatherapp.data.remote.dto.WeatherDto
import retrofit2.http.GET

interface WeatherApi {

    @GET("")
    suspend fun getWeatherData(): WeatherDto
}