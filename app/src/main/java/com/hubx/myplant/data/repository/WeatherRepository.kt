package com.hubx.myplant.data.repository

import com.hubx.myplant.domain.model.Weather

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): Weather
}