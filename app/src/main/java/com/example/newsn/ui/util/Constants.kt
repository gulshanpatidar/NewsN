package com.example.newsn.ui.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.newsn.ui.models.BottomNavItem

object Constants {

    val bottomNavItems = listOf(
        BottomNavItem(
            label = "home",
            icon = Icons.Default.Home,
            route = Routes.Home.route
        ),
        BottomNavItem(
            label = "search",
            icon = Icons.Default.Search,
            route = Routes.Search.route
        ),
        BottomNavItem(
            label = "genre",
            icon = Icons.Default.Category,
            route = Routes.Category.route
        ),
        BottomNavItem(
            label = "saved",
            icon = Icons.Default.Save,
            route = Routes.Saved.route
        ),
        BottomNavItem(
            label = "profile",
            icon = Icons.Default.Person,
            route = Routes.Profile.route
        )
    )
}