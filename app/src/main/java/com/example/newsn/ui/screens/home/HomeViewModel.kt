package com.example.newsn.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsn.data.remote.api.NewsService
import com.example.newsn.data.remote.dto.News
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val news: MutableState<List<News>> = mutableStateOf(listOf())
    private val service = NewsService.create()

    val searchQuery: MutableState<String> = mutableStateOf("")
    val searchResponse: MutableState<List<News>> = mutableStateOf(ArrayList())

    val category: MutableState<String> = mutableStateOf("")
    val country: MutableState<String> = mutableStateOf("")

    init {
        getNews()
    }

    fun getNews(country: String = "in",category: String = ""){
        viewModelScope.launch {
            news.value = service.getTopHeadlines(country,category)
        }
    }

    fun searchNews(query: String){
        viewModelScope.launch {
            searchResponse.value = service.getSpecificNews(query)
        }
    }
}