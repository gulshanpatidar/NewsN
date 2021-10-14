package com.example.newsn.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.example.newsn.ui.AppNavigation
import com.example.newsn.ui.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun ScaffoldUse(navController: NavHostController,viewModel: HomeViewModel) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))

    //use coroutine to open and close drawer
    val coroutineScope = rememberCoroutineScope()
    
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar( onMenuClicked = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            } )
        },
        bottomBar = {
            BottomBar(navController = navController)
        },
        drawerContent = {
            Drawer()
        }
    ){ innerPadding ->
        AppNavigation(viewModel = viewModel, navController = navController,innerPadding)
    }
}