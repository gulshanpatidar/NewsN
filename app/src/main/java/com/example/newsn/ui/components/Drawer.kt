package com.example.newsn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

        repeat(5){ item ->
            Text(text = "Item number $item",modifier = Modifier.padding(8.dp),color = Color.Black)
        }
    }
}