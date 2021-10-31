package com.example.newsn.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.newsn.ui.AppNavigation
import com.example.newsn.ui.screens.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun ScaffoldUse(
    title: String,
    navController: NavHostController,
    viewModel: HomeViewModel?,
    content: @Composable () -> Unit
) {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))

    //use coroutine to open and close drawer
    val coroutineScope = rememberCoroutineScope()

    if (viewModel!=null){
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopBar(
                    title = title,
                    viewModel = viewModel,
                    onMenuClicked = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            bottomBar = {
                BottomBar(navController = navController)
            },
            drawerContent = {
                Drawer(viewModel) {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                content()
            }
        }
    }else{
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopBar(
                    title = title,
                    viewModel = viewModel,
                    onMenuClicked = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            bottomBar = {
                BottomBar(navController = navController)
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                content()
            }
        }
    }
}