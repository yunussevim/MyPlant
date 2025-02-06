package com.hubx.myplant.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hubx.myplant.domain.usecase.GetArticlesUseCase
import com.hubx.myplant.domain.usecase.GetPlantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    getPlantsUseCase: GetPlantsUseCase,
    getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    val plants = getPlantsUseCase().asLiveData()
    val articles = getArticlesUseCase().asLiveData()
}