package com.koczuba.kotlincomposeweatherapp.features.weatherforecast.data.models

import com.koczuba.kotlincomposeweatherapp.BuildConfig

data class WeatherForecastEntry(
    val appId: String = BuildConfig.API_KEY,
    val lat: Double,
    val long: Double,
)