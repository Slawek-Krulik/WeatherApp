package com.interview.weatherapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val date: String? = "",
    val temperature: String?,
    val humidity: String?,
    val city: String? = "",
    val icon: Icon?
): Parcelable {
    constructor(weather: Weather?) : this(
        temperature = weather?.temperature,
        humidity = weather?.humidity,
        icon = weather?.icon
    )
}
