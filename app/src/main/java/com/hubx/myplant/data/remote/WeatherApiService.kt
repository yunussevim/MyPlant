package com.hubx.myplant.data.remote

import com.hubx.myplant.BuildConfig
import com.hubx.myplant.data.remote.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String = BuildConfig.WEATHER_API_KEY,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}