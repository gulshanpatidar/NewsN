package com.example.newsn.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsn.ui.models.Country
import com.example.newsn.ui.screens.home.HomeViewModel

@Composable
fun DropDownMenuImpl(viewModel: HomeViewModel) {

    val countryList = listOf(
        Country("India","in"),
        Country("USA","us"),
        Country("Australia","au"),
        Country("Canada","ca"),
        Country("UK","gb"),
    )

    var countryName: String by remember {
        mutableStateOf(countryList[0].countryName)
    }

    var expanded by remember {
        mutableStateOf(false)
    }
    Row(
        Modifier.clickable(onClickLabel = "country") {
            expanded = !expanded
        }
    ) {

        Text(text = countryName)
        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            countryList.forEach { country ->
                DropdownMenuItem(onClick = {
                    viewModel.getNews(country = country.countryCode, category = viewModel.category.value)
                    expanded = false
                    countryName = country.countryName
                }) {
                    val isSelected = country.countryName == countryName
                    val style = if (isSelected) {
                        MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.secondary
                        )
                    } else {
                        MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colors.onSurface
                        )
                    }
                    Text(text = country.countryName, style = style)
                }
            }
        }
    }
}
