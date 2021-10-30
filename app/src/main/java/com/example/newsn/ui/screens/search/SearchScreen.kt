package com.example.newsn.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.newsn.ui.screens.home.HomeViewModel
import com.example.newsn.ui.screens.home.NewsCard

@ExperimentalCoilApi
@Composable
fun SearchScreen(viewModel: HomeViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {

        var query by remember {
            viewModel.searchQuery
        }

        var news by remember {
            viewModel.searchResponse
        }

        Column(modifier = Modifier.fillMaxSize()) {
            SearchBar(query, onQueryFilled = {
                viewModel.searchQuery.value = it
                query = it
            }) {
                viewModel.searchNews(query = query)
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn{
                items(news){
                    NewsCard(news = it)
                }
            }
        }


//        Text(
//            text = "Search your favorite topic",
//            modifier = Modifier.align(Alignment.Center)
//        )
    }
}

@Composable
internal fun SearchBar(
    query: String,
    onQueryFilled: (String) -> Unit,
    onButtonClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.clip(RoundedCornerShape(32.dp))
        ) {
            TextField(
                value = query, onValueChange = {
                    onQueryFilled(it)
                },
                placeholder = {
                    Text(text = "Search you favourite topic")
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
        IconButton(
            onClick = {
                onButtonClicked()
            },
            Modifier.padding(start = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search News",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.secondary)
                    .padding(8.dp)
                    .size(45.dp),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun SamplePreview() {
    SearchBar("Hello", {}, {})
}