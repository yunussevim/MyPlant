package com.hubx.myplant.di

import android.content.Context
import androidx.room.Room
import com.hubx.myplant.data.local.AppDatabase
import com.hubx.myplant.data.repository.ArticleRepository
import com.hubx.myplant.data.repository.ArticleRepositoryImpl
import com.hubx.myplant.data.repository.PlantRepository
import com.hubx.myplant.data.repository.PlantRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providePlantDao(database: AppDatabase) = database.plantDao()

    @Provides
    fun provideArticleDao(database: AppDatabase) = database.articleDao()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPlantRepository(
        impl: PlantRepositoryImpl
    ): PlantRepository

    @Binds
    @Singleton
    abstract fun bindArticleRepository(
        impl: ArticleRepositoryImpl
    ): ArticleRepository
}