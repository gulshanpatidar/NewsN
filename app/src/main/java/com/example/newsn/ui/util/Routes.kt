package com.example.newsn.ui.util

sealed class Routes(val route: String){

    object Home: Routes("home_screen")
    object Profile: Routes("profile_screen")
    object Category: Routes("category_screen")
    object Search: Routes("search_screen")
    object Saved: Routes("saved_screen")
    object Splash: Routes("splash_screen")
}
