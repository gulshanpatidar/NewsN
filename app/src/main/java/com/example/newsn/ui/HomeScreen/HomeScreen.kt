package com.example.newsn.ui.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
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
            Card(
                backgroundColor = MaterialTheme.colors.background,
                modifier = Modifier.padding(vertical = 16.dp),
                elevation = 3.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                ) {
                    it.urlToImage?.let { url ->
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
                            text = it.title.toString(),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
}