package com.koczuba.kotlincomposeweatherapp.utils

object Constants {
    private const val BASE_URL = "https://api.openweathermap.org"
    const val WEATHER_URL = "$BASE_URL/data/2.5/"
    const val GEOCODING_URL = "$BASE_URL/geo/1.0/direct/"
}