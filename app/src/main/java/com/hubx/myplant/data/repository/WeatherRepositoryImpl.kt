package com.hubx.myplant.data.repository

import com.hubx.myplant.data.remote.WeatherApiService
import com.hubx.myplant.domain.model.Weather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val apiService: WeatherApiService
) : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): Weather {
        val response = apiService.getCurrentWeather(city)
        val temperature = response.main.temperature
        val weatherData = response.weather.firstOrNull()
        return Weather(
            temperature = temperature,
            description = weatherData?.description ?: "No Data",
            icon = weatherData?.icon ?: ""
        )
    }
}