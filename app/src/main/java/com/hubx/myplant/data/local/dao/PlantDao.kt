package com.hubx.myplant.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hubx.myplant.data.local.entity.PlantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<PlantEntity>)

    @Query("SELECT * FROM plants ORDER BY rank ASC")
    fun getAllPlantsSorted(): Flow<List<PlantEntity>>
}