package com.koczuba.kotlincomposeweatherapp.domain.repository

import com.koczuba.kotlincomposeweatherapp.data.OpenWeatherApi
import com.koczuba.kotlincomposeweatherapp.data.reponses.todaysweather.TodaysWeatherResponse
import com.koczuba.kotlincomposeweatherapp.data.reponses.weatherforecast.WeatherForecastResponse
import com.koczuba.kotlincomposeweatherapp.domain.models.Weather
import com.koczuba.kotlincomposeweatherapp.domain.models.WeatherForecast
import com.koczuba.kotlincomposeweatherapp.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject


@ActivityScoped
class WeatherRepositoryImplementation @Inject constructor(
    private val api: OpenWeatherApi
) : WeatherRepository {


    private fun getDate(timestamp: Int): String {
        val simpleDateFormat = SimpleDateFormat("dd-MMMM-yyyy, HH:mm:ss", Locale.ROOT)
        return simpleDateFormat.format(timestamp * 1000L)
    }

    private fun getDayName(date: String): String {
        val simpleDateFormat = SimpleDateFormat("EEEE", Locale.ROOT)
        return simpleDateFormat.format(date)
    }


    private fun makeWeather(weather: TodaysWeatherResponse): Weather {
        val date = getDate(weather.dt)
        val dayName = getDayName(date)
        return Weather(
            city = weather.name,
            dayName = dayName,
            fullDate = date,
            description = weather.weather.first().description,
            temp = weather.main.temp,
            minTemp = weather.main.tempMin,
            maxTemp = weather.main.tempMax,
            icon = weather.weather.first().icon
        )

    }

    private fun makeWeather(weathers: WeatherForecastResponse): List<Weather> {
        val city = weathers.city.name
        return weathers.list.map { weather ->
            val date = getDate(weather.dt)
            val dayName = getDayName(date)
            Weather(
                city = city,
                dayName = dayName,
                fullDate = date,
                description = weather.weather.first().description,
                temp = weather.main.temp,
                minTemp = weather.main.tempMin,
                maxTemp = weather.main.tempMax,
                icon = weather.weather.first().icon
            )


        }

    }


    override suspend fun getWeatherForecast(lat: Double, long: Double): Resource<WeatherForecast> {
        try {
            val todaysWeatherResponse = api.getTodaysWeather(lat, long)
            val weatherForecastResponse = api.getWeatherForecast(lat, long)
            return Resource.Success(
                WeatherForecast(
                    makeWeather(todaysWeatherResponse),
                    makeWeather(weatherForecastResponse)
                )
            )
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
    }

}