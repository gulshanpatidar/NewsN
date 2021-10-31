package com.example.newsn

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.newsn.ui.AppNavigation
import com.example.newsn.ui.components.ScaffoldUse
import com.example.newsn.ui.screens.home.HomeViewModel
import com.example.newsn.ui.theme.NewsNTheme

@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsNTheme(darkTheme = false) {
                val connectivityManager =
                    getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (
                    activeNetworkInfo != null && activeNetworkInfo.isConnected
                ) {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        val navController = rememberNavController()
                        AppNavigation(viewModel = viewModel, navController = navController)
                    }
                }else{
                    NetworkError()
                }
            }
        }
    }
}

@Composable
fun NetworkError() {
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
        Image(imageVector = Icons.Filled.Error, contentDescription = "Error image",modifier = Modifier.size(100.dp))
        Text(text = "No internet connection",
            textAlign = TextAlign.Center,
            fontSize = 25.sp)
    }
}



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    NewsNTheme {
//        Greeting(posts)
//    }
//}