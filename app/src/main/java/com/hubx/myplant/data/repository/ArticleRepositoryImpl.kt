package com.hubx.myplant.data.repository

import android.content.Context
import com.hubx.myplant.data.local.dao.ArticleDao
import com.hubx.myplant.data.local.entity.ArticleEntity
import com.hubx.myplant.domain.model.Article
import com.hubx.myplant.util.JsonUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepositoryImpl @Inject constructor(
    private val articleDao: ArticleDao,
    @ApplicationContext private val context: Context
) : ArticleRepository {
    override fun getArticlesSorted(): Flow<List<Article>> {
        return articleDao.getAllArticlesSorted().map { entityList ->
            entityList.map { it.toArticle() }
        }
    }

    override suspend fun insertArticles(articles: List<Article>) {
        val entities = articles.map { it.toArticleEntity() }
        articleDao.insertAll(entities)
    }

    override suspend fun seedDatabaseArticlesFromJson() {
        withContext(Dispatchers.IO) {
            val articlesFromJson = JsonUtils.loadArticlesFromAsset(context, "questions.json")
            insertArticles(articlesFromJson)
        }
    }
}

fun ArticleEntity.toArticle(): Article {
    return Article(
        id = id,
        title = title,
        subtitle = subtitle,
        imageUri = imageUri,
        uri = uri,
        order = order
    )
}

fun Article.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
        id = id,
        title = title,
        subtitle = subtitle,
        imageUri = imageUri,
        uri = uri,
        order = order
    )
}