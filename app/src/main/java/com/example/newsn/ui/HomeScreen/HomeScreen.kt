package com.example.newsn.ui.HomeScreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.newsn.data.remote.dto.News
import com.example.newsn.ui.HomeScreen.components.LoadingNewsListShimmer

@ExperimentalCoilApi
@Composable
fun HomeScreen(news: State<List<News>>, navController: NavHostController) {
    LazyColumn {
        items(news.value) {
            NewsCard(news = it)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun NewsCard(news: News) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val surfaceColor: Color by animateColorAsState(if (isExpanded) MaterialTheme.colors.secondary else MaterialTheme.colors.surface)
    Card(
        backgroundColor = surfaceColor,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .animateContentSize(),
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isExpanded = !isExpanded },
        ) {
            news.urlToImage?.let { url ->
                val painter = rememberImagePainter(data = url)
                val state = painter.state
                if (state is ImagePainter.State.Loading) {
                    //image is loading
                    LoadingNewsListShimmer(imageHeight = 220.dp)
                } else if (state is ImagePainter.State.Error) {
                    Text(text = "An error occurred")
                } else {
                    Image(
                        painter = painter,
                        contentDescription = "This is image associated with news",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                    )
                }
                Text(
                    text = news.title.toString(),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                if (isExpanded) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = news.description.toString(),
                        style = MaterialTheme.typography.body2,
                        color = Color(0xff7a7973),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    val content = news.content.toString()
                    if (content.contains("...")){
                        content.dropLastWhile {
                            it == '.'
                        }
                    }
                    Text(
                        text = content,
                        style = MaterialTheme.typography.body2,
                        color = Color(0xff7a7973),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }
}