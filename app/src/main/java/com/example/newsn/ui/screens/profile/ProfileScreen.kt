package com.example.newsn.ui.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.newsn.ui.components.ScaffoldUse

@Composable
fun ProfileScreen(navController: NavHostController) {

    ScaffoldUse(title = "Profile", navController = navController, viewModel = null) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "This is your profile",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}