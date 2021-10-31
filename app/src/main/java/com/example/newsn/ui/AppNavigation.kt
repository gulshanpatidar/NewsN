package com.example.newsn.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.newsn.ui.screens.home.HomeScreen
import com.example.newsn.ui.screens.home.HomeViewModel
import com.example.newsn.ui.screens.home.SplashScreen
import com.example.newsn.ui.screens.profile.ProfileScreen
import com.example.newsn.ui.screens.saved.SavedScreen
import com.example.newsn.ui.screens.search.SearchScreen
import com.example.newsn.ui.util.Routes

@ExperimentalCoilApi
@Composable
fun AppNavigation(
    viewModel: HomeViewModel,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {
        //splash screen
        composable(Routes.Splash.route) {
            SplashScreen(navController = navController)
        }
        //main screen
        composable(Routes.Home.route) {
            HomeScreen(viewModel, navController = navController)
        }

        composable(Routes.Profile.route) {
            ProfileScreen(navController)
        }

        composable(Routes.Search.route) {
            SearchScreen(navController,viewModel)
        }

        composable(Routes.Saved.route){
            SavedScreen(navController = navController)
        }
    }
}