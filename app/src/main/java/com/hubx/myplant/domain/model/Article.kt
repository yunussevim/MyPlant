package com.hubx.myplant.domain.model

data class Article(
    val id: Int,
    val title: String,
    val subtitle: String,
    val imageUri: String,
    val uri: String,
    val order: Int
)