package com.hubx.myplant.domain.usecase

import com.hubx.myplant.data.repository.PlantRepository
import com.hubx.myplant.domain.model.Plant
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlantsUseCase @Inject constructor(
    private val repository: PlantRepository
) {
    operator fun invoke(): Flow<List<Plant>> {
        return repository.getPlantsSortedByRank()
    }
}