package com.koczuba.kotlincomposeweatherapp.features.weatherforecast.domain.repository

import com.koczuba.kotlincomposeweatherapp.features.weatherforecast.domain.models.WeatherForecast
import com.koczuba.kotlincomposeweatherapp.core.utils.Resource

interface WeatherRepository {
    suspend fun getWeatherForecast(lat: Double, long: Double): Resource<WeatherForecast>
}