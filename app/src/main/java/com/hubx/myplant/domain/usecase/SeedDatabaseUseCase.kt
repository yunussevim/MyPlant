package com.hubx.myplant.domain.usecase

import com.hubx.myplant.data.repository.ArticleRepository
import com.hubx.myplant.data.repository.PlantRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SeedDatabaseUseCase @Inject constructor(
    private val plantRepository: PlantRepository,
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke() {
        withContext(Dispatchers.IO) {
            plantRepository.seedDatabasePlantsFromJson()
            articleRepository.seedDatabaseArticlesFromJson()
        }
    }
}