package com.koczuba.kotlincomposeweatherapp.core.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.koczuba.kotlincomposeweatherapp.features.weatherforecast.data.OpenWeatherApi
import com.koczuba.kotlincomposeweatherapp.features.weatherforecast.domain.repository.WeatherRepository
import com.koczuba.kotlincomposeweatherapp.features.weatherforecast.domain.repository.WeatherRepositoryImplementation
import com.koczuba.kotlincomposeweatherapp.core.utils.Constants.WEATHER_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideWeatherRepository(
        api: OpenWeatherApi
    ) = WeatherRepositoryImplementation(api) as WeatherRepository

    @Singleton
    @Provides
    fun provideWeatherApi(): OpenWeatherApi {
        val networkJson = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .baseUrl(WEATHER_URL)
            .build()
            .create(OpenWeatherApi::class.java)
    }
}