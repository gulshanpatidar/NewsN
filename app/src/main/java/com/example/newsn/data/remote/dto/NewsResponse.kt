package com.example.newsn.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val status: String,
    val  totalResults: Int,
    val articles: List<News>
)