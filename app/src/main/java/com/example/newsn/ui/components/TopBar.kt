package com.example.newsn.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.newsn.ui.screens.home.HomeViewModel

//onMenuClicked is a triggering function
@Composable
fun TopBar(title: String,viewModel: HomeViewModel?, onMenuClicked: () -> Unit) {

    if (viewModel != null) {
        TopAppBar(
            title = {
                Row {
                    Text(text = title, color = Color.White)
                    Spacer(modifier = Modifier.width(90.dp))
                    DropDownMenuImpl(viewModel)
                }
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    //when click on menu, triggering function should call
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable(onClick = onMenuClicked),
                    tint = Color.White
                )
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    }else{
        TopAppBar(
            title = {
                Row {
                    Text(text = title, color = Color.White)
                    Spacer(modifier = Modifier.width(90.dp))
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    }

}