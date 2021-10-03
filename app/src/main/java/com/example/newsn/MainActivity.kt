package com.example.newsn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.newsn.data.remote.api.NewsService
import com.example.newsn.data.remote.dto.News
import com.example.newsn.ui.theme.NewsNTheme
import com.google.accompanist.coil.CoilImage

class MainActivity : ComponentActivity() {

    private val service = NewsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val news = produceState<List<News>>(
                initialValue = emptyList(),
                producer = {
                    value = service.getTopHeadlines()
                }
            )
            NewsNTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(news)
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun Greeting(posts: State<List<News>>) {
    LazyColumn {
        items(posts.value) {
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = it.urlToImage,
                            builder = {

                            }
                        ),
                        contentDescription = "This is image associated with news",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                    )
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

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    NewsNTheme {
//        Greeting(posts)
//    }
//}