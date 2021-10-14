package com.example.newsn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsn.ui.screens.home.HomeViewModel

@Composable
fun Drawer(viewModel: HomeViewModel,closeDrawer: () -> Unit) {

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth()) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Categories",
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .background(MaterialTheme.colors.primary),
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
        Divider(Modifier.height(1.dp))
        Text(
            text = "Top Headlines",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.getNews(category = "general")
                    closeDrawer()
                }
                .padding(12.dp),
            fontSize = 20.sp
        )
        Divider(modifier = Modifier.height(1.dp))
        Text(
            text = "Sports",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.getNews(category = "sports")
                    closeDrawer()
                }
                .padding(12.dp),
            fontSize = 20.sp
        )
        Divider(modifier = Modifier.height(1.dp))
        Text(
            text = "Entertainment",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.getNews(category = "entertainment")
                    closeDrawer()
                }
                .padding(12.dp),
            fontSize = 20.sp
        )
        Divider(modifier = Modifier.height(1.dp))
        Text(
            text = "Technology",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.getNews(category = "technology")
                    closeDrawer()
                }
                .padding(12.dp),
            fontSize = 20.sp
        )
        Divider(modifier = Modifier.height(1.dp))
        Text(
            text = "Business",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.getNews(category = "business")
                    closeDrawer()
                }
                .padding(12.dp),
            fontSize = 20.sp
        )
        Divider(modifier = Modifier.height(1.dp))
        Text(
            text = "Health",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.getNews(category = "health")
                    closeDrawer()
                }
                .padding(12.dp),
            fontSize = 20.sp
        )
        Divider(modifier = Modifier.height(1.dp))
        Text(
            text = "Science",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.getNews(category = "science")
                    closeDrawer()
                }
                .padding(12.dp),
            fontSize = 20.sp
        )
        Divider(Modifier.height(1.dp))
    }
}