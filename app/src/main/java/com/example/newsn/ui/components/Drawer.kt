package com.example.newsn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Drawer() {
    
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Top headlines")
        Divider(modifier = Modifier.height(8.dp))
        Text(text = "Sports")
        Divider(modifier = Modifier.height(8.dp))
        Text(text = "Entertainment")
        Divider(modifier = Modifier.height(8.dp))
        Text(text = "Technology")
        Divider(modifier = Modifier.height(8.dp))
        Text(text = "Business")
        Divider(modifier = Modifier.height(8.dp))
        Text(text = "Education")
        Divider(modifier = Modifier.height(8.dp))
        Text(text = "Politics")
    }
}