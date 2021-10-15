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
import com.example.newsn.ui.util.Constants

@Composable
fun Drawer(viewModel: HomeViewModel, closeDrawer: () -> Unit) {

    val categories = Constants.categories

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxWidth()
        ) {
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
        categories.forEach { category ->
            Text(
                text = category.categoryName,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.category.value = category.categoryCode
                        viewModel.getNews(category = category.categoryCode)
                        closeDrawer()
                    }
                    .padding(12.dp),
                fontSize = 20.sp
            )
            Divider(modifier = Modifier.height(1.dp))
        }
    }
}