package com.koczuba.kotlincomposeweatherapp.features.weatherforecast.data.reponses.weatherforecast


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName("pod")
    val pod: String
)