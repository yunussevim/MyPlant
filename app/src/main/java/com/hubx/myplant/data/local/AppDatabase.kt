package com.hubx.myplant.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hubx.myplant.data.local.dao.ArticleDao
import com.hubx.myplant.data.local.dao.PlantDao
import com.hubx.myplant.data.local.entity.ArticleEntity
import com.hubx.myplant.data.local.entity.PlantEntity

@Database(entities = [PlantEntity::class, ArticleEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao
    abstract fun articleDao(): ArticleDao
}