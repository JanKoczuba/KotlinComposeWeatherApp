package com.koczuba.kotlincomposeweatherapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.koczuba.kotlincomposeweatherapp.data.OpenWeatherApi
import com.koczuba.kotlincomposeweatherapp.domain.repository.WeatherRepository
import com.koczuba.kotlincomposeweatherapp.domain.repository.WeatherRepositoryImplementation
import com.koczuba.kotlincomposeweatherapp.utils.Constants.WEATHER_URL
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