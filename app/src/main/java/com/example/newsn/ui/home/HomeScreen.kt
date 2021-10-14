package com.example.newsn.ui.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.newsn.data.remote.dto.News
import com.example.newsn.ui.home.components.LoadingNewsListShimmer
import com.example.newsn.ui.components.ScaffoldUse

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
                    Image(
                        imageVector = Icons.Outlined.Image,
                        contentDescription = "Error image",
                        modifier = Modifier
                            .size(220.dp)
                            .align(Alignment.CenterHorizontally)
                    )
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
                    val content = news.content
                    content?.let {
                        Text(
                            text = content.toString().dropLast(13),
                            style = MaterialTheme.typography.body2,
                            color = Color(0xff7a7973),
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                    ReadMoreButton(url = news.url)
                }
            }
        }
    }
}

@Composable
fun ReadMoreButton(url: String?) {

    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 12.sp)) {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("Read more")
                }
            }
        },
        onClick = {
            url?.let {
                uriHandler.openUri(it)
            }
        },
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}