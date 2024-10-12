package com.koczuba.kotlincomposeweatherapp.data.reponses.weatherforecast


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class City(
    @SerialName("coord")
    val coord: Coord,
    @SerialName("country")
    val country: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("population")
    val population: Int,
    @SerialName("sunrise")
    val sunrise: Int,
    @SerialName("sunset")
    val sunset: Int,
    @SerialName("timezone")
    val timezone: Int
)