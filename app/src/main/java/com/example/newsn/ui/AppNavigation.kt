package com.example.newsn.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.newsn.ui.category.CategoryScreen
import com.example.newsn.ui.home.HomeScreen
import com.example.newsn.ui.home.HomeViewModel
import com.example.newsn.ui.home.SplashScreen
import com.example.newsn.ui.profile.ProfileScreen
import com.example.newsn.ui.saved.SavedScreen
import com.example.newsn.ui.search.SearchScreen
import com.example.newsn.ui.util.Routes

@ExperimentalCoilApi
@Composable
fun AppNavigation(
    viewModel: HomeViewModel,
    navController: NavHostController,
    innerPadding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        //splash screen
        composable(Routes.Splash.route) {
            SplashScreen(navController = navController)
        }
        //main screen
        composable(Routes.Home.route) {
            HomeScreen(news = viewModel.news, navController = navController)
        }

        composable(Routes.Profile.route) {
            ProfileScreen()
        }

        composable(Routes.Search.route) {
            SearchScreen()
        }

        composable(Routes.Category.route){
            CategoryScreen()
        }

        composable(Routes.Saved.route){
            SavedScreen()
        }
    }
}