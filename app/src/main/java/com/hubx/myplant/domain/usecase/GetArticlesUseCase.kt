package com.hubx.myplant.domain.usecase

import com.hubx.myplant.data.repository.ArticleRepository
import com.hubx.myplant.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository
) {
    operator fun invoke(): Flow<List<Article>> = repository.getArticlesSorted()
}