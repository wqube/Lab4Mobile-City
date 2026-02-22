package com.example.city.ui.navigation

sealed class AppDestination(
    val route: String,
    val isTopLevel: Boolean
) {
    object Home : AppDestination(Routes.HomePage.route, true)
    object Category : AppDestination(Routes.Category.route, true)
    object About : AppDestination(Routes.About.route, true)
    object Settings : AppDestination(Routes.Settings.route, true)
    object Explore : AppDestination(Routes.Explore.route, true)
    object Favorites : AppDestination(Routes.Favorites.route, true)

    object Recommendation :
        AppDestination(Routes.Recommendation.route, false)
}
