package com.interview.weatherapp.data.remote.model

data class Forecastday(
    val astro: Astro?,
    val date: String?,
    val date_epoch: Int?,
    val day: Day?,
    val hour: List<Hour>?
)