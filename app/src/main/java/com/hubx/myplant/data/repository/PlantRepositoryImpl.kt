package com.hubx.myplant.data.repository

import android.content.Context
import com.hubx.myplant.data.local.dao.PlantDao
import com.hubx.myplant.data.local.entity.PlantEntity
import com.hubx.myplant.domain.model.Plant
import com.hubx.myplant.util.JsonUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlantRepositoryImpl @Inject constructor(
    private val plantDao: PlantDao,
    @ApplicationContext private val context: Context
) : PlantRepository {

    override fun getPlantsSortedByRank(): Flow<List<Plant>> {
        return plantDao.getAllPlantsSorted().map { entityList ->
            entityList.map { it.toPlant() }.sortedBy { a -> a.rank }
        }
    }

    override suspend fun insertPlants(plants: List<Plant>) {
        val entities = plants.map { it.toPlantEntity() }
        plantDao.insertAll(entities)
    }

    override suspend fun seedDatabasePlantsFromJson() {
        withContext(Dispatchers.IO) {
            val plantsFromJson = JsonUtils.loadPlantsFromAsset(context, "plants.json")
            insertPlants(plantsFromJson)
        }
    }

    fun PlantEntity.toPlant(): Plant {
        return Plant(
            id = id,
            name = name,
            title = title,
            rank = rank,
            imageUrl = imageUrl
        )
    }

    fun Plant.toPlantEntity(): PlantEntity {
        return PlantEntity(
            id = id,
            name = name,
            title = title,
            rank = rank,
            imageUrl = imageUrl
        )
    }
}