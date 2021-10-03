package com.example.newsn.data.remote.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class NewsSource(
    val id: String?,
    val name: String
)