package com.koczuba.kotlincomposeweatherapp.features.weatherforecast.data.reponses.todaysweather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Clouds(
    @SerialName("all")
    val all: Int
)