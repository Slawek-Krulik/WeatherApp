package com.interview.weatherapp.di

import com.interview.weatherapp.data.exception.mapper.ErrorMapper
import com.interview.weatherapp.data.exception.mapper.ErrorMapperImpl
import com.interview.weatherapp.data.exception.wrapper.ErrorWrapper
import com.interview.weatherapp.data.exception.wrapper.ErrorWrapperImpl
import com.interview.weatherapp.data.repository.WeatherRepositoryImpl
import com.interview.weatherapp.domain.weather.DateConverter
import com.interview.weatherapp.domain.weather.GetWeatherUseCase
import com.interview.weatherapp.domain.weather.converter.DateConverterImpl
import com.interview.weatherapp.domain.weather.repository.WeatherRepository
import com.interview.weatherapp.presentation.WeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single <ErrorWrapper> { ErrorWrapperImpl() }

    single <ErrorMapper> { ErrorMapperImpl(androidContext()) }

    single <WeatherRepository> { WeatherRepositoryImpl(get(), get()) }

    single <DateConverter> { DateConverterImpl() }

    single<GetWeatherUseCase> { GetWeatherUseCase(get(),get()) }

    viewModel { WeatherViewModel(get(), get(), get()) }
}