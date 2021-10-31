package com.example.newsn.ui.screens.saved

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.newsn.ui.components.ScaffoldUse

@Composable
fun SavedScreen(navController: NavHostController) {
    ScaffoldUse(title = "Saved News", navController = navController, viewModel = null) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "save your favorite news",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}