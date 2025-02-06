package com.hubx.myplant.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.hubx.myplant.domain.model.Article
import com.hubx.myplant.domain.model.Plant

data class ApiResponse(
    val data: List<PlantJson>
)

data class PlantJson(
    val id: Int,
    val name: String,
    val title: String,
    val rank: Int,
    val image: ImageJson
)

data class ImageJson(
    val url: String
)

data class ArticleApiResponse(
    val data: List<ArticleJson>
)

data class ArticleJson(
    val id: Int,
    val title: String,
    val subtitle: String,
    @SerializedName("image_uri") val imageUri: String,
    val uri: String,
    @SerializedName("order") val order: Int
)

object JsonUtils {
    fun loadPlantsFromAsset(context: Context, fileName: String = "plants.json"): List<Plant> {
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        val gson = Gson()
        val type = object : TypeToken<ApiResponse>() {}.type
        val response: ApiResponse = gson.fromJson(jsonString, type)
        return response.data.map { plantJson ->
            Plant(
                id = plantJson.id,
                name = plantJson.name,
                title = plantJson.title,
                rank = plantJson.rank,
                imageUrl = plantJson.image.url
            )
        }
    }

    fun loadArticlesFromAsset(context: Context, fileName: String = "questions.json"): List<Article> {
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        val gson = Gson()
        val type = object : TypeToken<ArticleApiResponse>() {}.type
        val response: ArticleApiResponse = gson.fromJson(jsonString, type)
        return response.data.map { articleJson ->
            Article(
                id = articleJson.id,
                title = articleJson.title,
                subtitle = articleJson.subtitle,
                imageUri = articleJson.imageUri,
                uri = articleJson.uri,
                order = articleJson.order
            )
        }
    }
}