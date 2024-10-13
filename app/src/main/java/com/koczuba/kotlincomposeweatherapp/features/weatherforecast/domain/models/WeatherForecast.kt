package com.koczuba.kotlincomposeweatherapp.features.weatherforecast.domain.models


data class WeatherForecast(
    val todaysWeather: Weather,
    val weatherForecast: List<Weather>,
    )


data class Weather(
    val city: String,
    val temp: Double,
    val minTemp: Double,
    val maxTemp: Double,
    val description: String,
    val icon: String,
    val fullDate: String,
    val dayName: String,
    )