package com.interview.weatherapp.di

import com.interview.weatherapp.BuildConfig
import com.interview.weatherapp.data.remote.ApiKeyInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module

val networkModule = module {

    single { provideApiKeyInterceptor() }

    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor(get<Interceptor>())
            .build()
    }

}

private fun provideApiKeyInterceptor(): Interceptor {
    return ApiKeyInterceptor(BuildConfig.API_KEY)
}