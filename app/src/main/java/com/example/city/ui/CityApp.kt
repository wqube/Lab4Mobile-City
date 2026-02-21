package com.example.city.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.city.ui.navigation.CityNavHost
import com.example.city.ui.components.CityTopBar

@Composable
fun CityApp() {
    // Этот контроллер хранит текущий экран, back stack, аргументы. Не пересоздается при рекомпозиции
    // navController создается благодаря нему
    val navController = rememberNavController()

    var topBarTitle by remember { mutableStateOf("City") }

    Scaffold(
        topBar = {
            CityTopBar(
                title = topBarTitle,
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        CityNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            onTitleChange = { title ->
                topBarTitle = title
            }
        )
    }
}