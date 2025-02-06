package com.hubx.myplant.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val subtitle: String,
    val imageUri: String,
    val uri: String,
    val order: Int
)