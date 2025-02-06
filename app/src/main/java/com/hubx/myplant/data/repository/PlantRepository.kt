package com.hubx.myplant.data.repository

import com.hubx.myplant.domain.model.Plant
import kotlinx.coroutines.flow.Flow

interface PlantRepository {
    fun getPlantsSortedByRank(): Flow<List<Plant>>
    suspend fun insertPlants(plants: List<Plant>)
    suspend fun seedDatabasePlantsFromJson()
}