package com.interview.weatherapp.domain.location

interface LocationTracker {

    suspend fun getCurrentLocation()
}