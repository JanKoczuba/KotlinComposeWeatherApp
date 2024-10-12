package com.koczuba.kotlincomposeweatherapp.weatherforecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koczuba.kotlincomposeweatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherForecastViewModel @Inject constructor(private val repository: WeatherRepository) :
    ViewModel() {

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            val result =
                repository.getWeatherForecast(
                    lat = 50.27870183780035,
                    long = 18.978320879946974
                )
        }
    }
}