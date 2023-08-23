package com.interview.weatherapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestWithKey = chain.request().newBuilder().addHeader(
            "Key", apiKey
        ).build()
        return chain.proceed(requestWithKey)
    }
}