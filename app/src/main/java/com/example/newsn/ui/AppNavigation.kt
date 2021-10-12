package com.example.newsn.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsn.data.remote.dto.News
import com.example.newsn.ui.HomeScreen.HomeScreen
import com.example.newsn.ui.HomeScreen.HomeViewModel
import com.example.newsn.ui.HomeScreen.SplashScreen

@Composable
fun AppNavigation(viewModel: HomeViewModel, navController: NavHostController) {

    NavHost(navController = navController, startDestination = "main_screen"){
        //splash screen
        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        //main screen
        composable("main_screen"){
            HomeScreen(news = viewModel.news,navController = navController)
        }
    }
}