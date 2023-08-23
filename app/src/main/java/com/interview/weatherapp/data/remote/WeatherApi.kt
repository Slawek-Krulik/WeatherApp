package com.interview.weatherapp.data.remote

import com.interview.weatherapp.data.remote.dto.WeatherRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current.json")
    suspend fun getWeatherData(
        @Query("q") coordinates: String?
    ): WeatherRemote
}