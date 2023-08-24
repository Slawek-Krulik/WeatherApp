package com.interview.weatherapp.domain.weather

interface DateConverter {
    fun convert(input: String?): String
}