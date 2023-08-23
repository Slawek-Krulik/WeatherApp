package com.interview.weatherapp.data.exception.wrapper

sealed class ServerExceptions(message: String?) : Throwable(message) {
    class Internal(message: String?) : ServerExceptions(message)
    class BadRequest(message: String?) : ServerExceptions(message)
    class Unknown(message: String?) : ServerExceptions(message)
}