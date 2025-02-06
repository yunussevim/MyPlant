package com.hubx.myplant.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hubx.myplant.data.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles ORDER BY `order` ASC")
    fun getAllArticlesSorted(): Flow<List<ArticleEntity>>
}