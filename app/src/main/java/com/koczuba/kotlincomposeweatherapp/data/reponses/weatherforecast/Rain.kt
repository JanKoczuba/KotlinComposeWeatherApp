package com.koczuba.kotlincomposeweatherapp.data.reponses.weatherforecast


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    @SerialName("3h")
    val h: Double
)