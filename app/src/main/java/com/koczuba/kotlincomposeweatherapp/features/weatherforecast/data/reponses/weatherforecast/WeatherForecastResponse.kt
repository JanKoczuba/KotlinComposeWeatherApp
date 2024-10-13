package com.koczuba.kotlincomposeweatherapp.features.weatherforecast.data.reponses.weatherforecast


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecastResponse(
    @SerialName("city")
    val city: City,
    @SerialName("cnt")
    val cnt: Int,
    @SerialName("cod")
    val cod: String,
    @SerialName("list")
    val list: List<Item0>,
    @SerialName("message")
    val message: Int
)