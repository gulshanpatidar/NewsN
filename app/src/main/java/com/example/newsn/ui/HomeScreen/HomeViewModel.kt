package com.example.newsn.ui.HomeScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsn.data.remote.api.NewsService
import com.example.newsn.data.remote.dto.News
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val news: MutableState<List<News>> = mutableStateOf(listOf())
    val service = NewsService.create()

    init {
        getNews()
    }

    fun getNews(){
        viewModelScope.launch {
            news.value = service.getTopHeadlines()
        }
    }
}