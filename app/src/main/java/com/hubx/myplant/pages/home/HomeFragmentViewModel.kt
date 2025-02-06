package com.hubx.myplant.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.hubx.myplant.domain.model.Weather
import com.hubx.myplant.domain.usecase.GetArticlesUseCase
import com.hubx.myplant.domain.usecase.GetPlantsUseCase
import com.hubx.myplant.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    getPlantsUseCase: GetPlantsUseCase,
    getArticlesUseCase: GetArticlesUseCase,
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {
    val plants = getPlantsUseCase().asLiveData()
    val articles = getArticlesUseCase().asLiveData()

    fun getWeather(city: String) = liveData {
        val weather: Weather = getWeatherUseCase(city)
        emit(weather)
    }
}