package com.interview.weatherapp.data.exception.mapper

interface ErrorMapper {
    fun map(throwable: Throwable): String
}