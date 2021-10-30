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

    override suspend fun getTopHeadlines(country: String,category: String): List<News> {
        val newsResponse = try {
            client.get<NewsResponse> {
                url(HttpRoutes.TOP_HEADLINES)
                parameter("language", "en")
                parameter("country",country)
                if (category.isNotEmpty()) {
                    parameter("category", category)
                }
                parameter("apiKey", HttpRoutes.API_KEY)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return emptyList()
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return emptyList()
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return emptyList()
        }

        return newsResponse.articles
    }

    override suspend fun getSpecificNews(query: String): List<News> {
        val newsResponse = try {
            client.get<NewsResponse>(HttpRoutes.TOP_HEADLINES){
                parameter("q",query)
                parameter("apiKey", HttpRoutes.API_KEY)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return emptyList()
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return emptyList()
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return emptyList()
        }

        return newsResponse.articles
    }
}