package com.hubx.myplant.data.remote.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("main")
    val main: MainData,
    @SerializedName("weather")
    val weather: List<WeatherData>
)

data class MainData(
    @SerializedName("temp")
    val temperature: Double
)

data class WeatherData(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)