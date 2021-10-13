package com.example.newsn.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffoldUse(screen: @Composable () -> Unit) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))

    //use coroutine to open and close drawer
    val coroutineScope = rememberCoroutineScope()
    
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar( onMenuClicked = {
                coroutineScope.launch {
//                    if (scaffoldState.drawerState==DrawerState(DrawerValue.Closed)) {
//                        scaffoldState.drawerState.open()
//                    }else{
//                        scaffoldState.drawerState.close()
//                    }
                    scaffoldState.drawerState.open()
                }
            } )
        },
        bottomBar = {
            BottomBar()
        },
        content = {
            screen()
        },
        drawerContent = {
            Drawer()
        }
    )
}