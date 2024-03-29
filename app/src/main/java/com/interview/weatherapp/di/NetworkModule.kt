package com.interview.weatherapp.di

import com.interview.weatherapp.BuildConfig
import com.interview.weatherapp.data.remote.ApiKeyInterceptor
import com.interview.weatherapp.data.remote.WeatherApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { provideApiKeyInterceptor() }

    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor(get<Interceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
            .create(WeatherApi::class.java)
    }
}

private fun provideApiKeyInterceptor(): Interceptor {
    return ApiKeyInterceptor(BuildConfig.API_KEY)
}