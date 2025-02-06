package com.hubx.myplant.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class PlantEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val title: String,
    val rank: Int,
    val imageUrl: String
)