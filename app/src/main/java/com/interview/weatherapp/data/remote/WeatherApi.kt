package com.interview.weatherapp.data.remote

import com.interview.weatherapp.data.remote.model.WeatherRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast.json")
    suspend fun getWeatherData(
        @Query("q") coordinates: String?,
        @Query("days") days: Int?
    ): WeatherRemote
}