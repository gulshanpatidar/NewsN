package com.example.newsn.data.remote

import com.example.newsn.data.remote.api.NewsService
import com.example.newsn.data.remote.dto.News
import com.example.newsn.data.remote.dto.NewsResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import java.lang.Exception

class NewsServiceImpl(
    private val client: HttpClient
) : NewsService {

    override suspend fun getTopHeadlines(): List<News> {
        val newsResponse =  try {
            client.get<NewsResponse> {
                url(HttpRoutes.TOP_HEADLINES)
                parameter("language","en")
                parameter("sortBy","publishedAt")
                parameter("apiKey",HttpRoutes.API_KEY)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: Exception) {
            println("Error: ${e.message}")
            null
        }
        if (newsResponse==null){
            return listOf()
        }
        return newsResponse.articles
    }
}