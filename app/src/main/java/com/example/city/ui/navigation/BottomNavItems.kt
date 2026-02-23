package com.example.city.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.city.R

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    @StringRes val labelResId: Int
) {
    object Home : BottomNavItem(Routes.HomePage.route, Icons.Default.Home, R.string.label_home)
    object Explore : BottomNavItem(Routes.Explore.route, Icons.Default.Place, R.string.label_explore)
    object Favorites : BottomNavItem(Routes.Favorites.route, Icons.Default.Favorite, R.string.label_favorite)
}