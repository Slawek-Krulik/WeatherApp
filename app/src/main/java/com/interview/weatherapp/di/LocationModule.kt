package com.interview.weatherapp.di

import com.google.android.gms.location.LocationServices
import com.interview.weatherapp.data.location.LocationTrackerImpl
import com.interview.weatherapp.domain.location.LocationTracker
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val locationModule = module {

    single<LocationTracker> { LocationTrackerImpl(androidApplication(), get()) }

    single { LocationServices.getFusedLocationProviderClient(androidApplication()) }
}