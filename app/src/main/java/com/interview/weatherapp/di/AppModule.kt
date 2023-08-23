package com.interview.weatherapp.di

import com.interview.weatherapp.data.exception.mapper.ErrorMapper
import com.interview.weatherapp.data.exception.mapper.ErrorMapperImpl
import com.interview.weatherapp.data.exception.wrapper.ErrorWrapper
import com.interview.weatherapp.data.exception.wrapper.ErrorWrapperImpl
import com.interview.weatherapp.data.repository.WeatherRepositoryImpl
import com.interview.weatherapp.domain.weather.WeatherRepository
import com.interview.weatherapp.presentation.WeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<ErrorWrapper> { ErrorWrapperImpl() }

    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }

    factory<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }

    viewModel { WeatherViewModel(get(), get()) }
}