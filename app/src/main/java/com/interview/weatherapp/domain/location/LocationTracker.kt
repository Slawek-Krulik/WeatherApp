package com.interview.weatherapp.domain.location

import com.interview.weatherapp.domain.location.model.Location

interface LocationTracker {

    suspend fun getCurrentLocation(): Location?
}