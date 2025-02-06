package com.hubx.myplant.domain.usecase

import com.hubx.myplant.data.repository.WeatherRepository
import com.hubx.myplant.domain.model.Weather
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(city: String): Weather {
        return repository.getCurrentWeather(city)
    }
}