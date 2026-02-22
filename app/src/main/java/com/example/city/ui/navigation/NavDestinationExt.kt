package com.example.city.ui.navigation

import androidx.navigation.NavDestination

fun NavDestination?.toAppDestination(): AppDestination? {
    return when (this?.route) {
        Routes.HomePage.route -> AppDestination.Home
        Routes.Category.route -> AppDestination.Category
        Routes.About.route -> AppDestination.About
        Routes.Settings.route -> AppDestination.Settings
        Routes.Recommendation.route -> AppDestination.Recommendation
        Routes.Explore.route -> AppDestination.Explore
        Routes.Favorites.route -> AppDestination.Favorites
        else -> null
    }
}