package com.interview.weatherapp.data.exception.wrapper

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}