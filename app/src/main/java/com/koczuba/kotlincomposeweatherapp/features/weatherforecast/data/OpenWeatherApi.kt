package com.koczuba.kotlincomposeweatherapp.features.weatherforecast.data

import com.koczuba.kotlincomposeweatherapp.BuildConfig
import com.koczuba.kotlincomposeweatherapp.features.weatherforecast.data.reponses.todaysweather.TodaysWeatherResponse
import com.koczuba.kotlincomposeweatherapp.features.weatherforecast.data.reponses.weatherforecast.WeatherForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET("weather")
    suspend fun getTodaysWeather(
        @Query("lat") lat: Double,
        @Query("long") long: Double,
        @Query("appId") appId: String = BuildConfig.API_KEY,
        @Query("units") units: String = "metric"
    ): TodaysWeatherResponse

    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("lat") lat: Double,
        @Query("long") long: Double,
        @Query("appId") appId: String = BuildConfig.API_KEY,
        @Query("units") units: String = "metric"
    ): WeatherForecastResponse

}