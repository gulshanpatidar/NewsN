package com.example.newsn.ui.components

import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomBar() {

    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Text(text = "Bottom app bar",color = Color.White)
    }
}