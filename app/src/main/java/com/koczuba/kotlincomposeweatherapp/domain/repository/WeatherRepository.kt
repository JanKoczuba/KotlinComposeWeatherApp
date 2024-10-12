package com.koczuba.kotlincomposeweatherapp.domain.repository

import com.koczuba.kotlincomposeweatherapp.domain.models.WeatherForecast
import com.koczuba.kotlincomposeweatherapp.utils.Resource

interface WeatherRepository {
    suspend fun getWeatherForecast(lat: Double, long: Double): Resource<WeatherForecast>
}