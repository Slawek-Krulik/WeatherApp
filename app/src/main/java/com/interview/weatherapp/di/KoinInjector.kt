package com.interview.weatherapp.di

import org.koin.core.module.Module

val koinInjector: List<Module> = appModule
    .plus(networkModule)
    .plus(locationModule)