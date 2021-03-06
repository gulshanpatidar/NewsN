package com.example.newsn.ui.screens.home

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newsn.R
import com.example.newsn.ui.util.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    //scale variable to animate splash screen
    val scale = remember {
        Animatable(0f)
    }

    //Animation Effect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(Routes.Home.route){
            popUpTo(Routes.Splash.route){
                inclusive = true
            }
        }
    }

    //show the image
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.newsn_logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(1000.dp).scale(scale = scale.value)
        )
    }
}