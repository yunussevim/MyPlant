package com.hubx.myplant.data.repository

import com.hubx.myplant.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticlesSorted(): Flow<List<Article>>
    suspend fun insertArticles(articles: List<Article>)
    suspend fun seedDatabaseArticlesFromJson()
}