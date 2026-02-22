package com.example.city.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : BottomNavItem(Routes.HomePage.route, Icons.Default.Home, "Home")
    object Explore : BottomNavItem(Routes.Explore.route, Icons.Default.Place, "Explore")
    object Favorites : BottomNavItem(Routes.Favorites.route, Icons.Default.Favorite, "Favorites")
}