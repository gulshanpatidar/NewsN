package com.example.newsn.data.remote.api

import com.example.newsn.data.remote.NewsServiceImpl
import com.example.newsn.data.remote.dto.News
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface NewsService {

    suspend fun getTopHeadlines(country: String,category: String): List<News>

    suspend fun getSpecificNews(query: String): List<News>

    companion object{
        fun create(): NewsService{
            return NewsServiceImpl(
                client = HttpClient(Android){
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(JsonFeature){
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}