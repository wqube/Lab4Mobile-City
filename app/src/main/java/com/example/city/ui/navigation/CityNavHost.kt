package com.example.city.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.city.ui.screens.HomeScreen
import androidx.navigation.navArgument
import com.example.city.data.CityRepository
import com.example.city.model.Category
import com.example.city.ui.screens.RecommendationScreen
import com.example.city.ui.screens.RecommendationsListScreen
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.city.ui.screens.AboutScreen
import com.example.city.ui.screens.ExploreScreen
import com.example.city.ui.screens.FavoritesScreen
import com.example.city.ui.screens.SettingsScreen

@Composable
fun CityNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onTitleChange: (String) -> Unit
) {
    // Контейнер экранов
    NavHost(
        navController = navController,
        startDestination = Routes.HomePage.route,
        modifier = modifier
    ) {
        // Home
        composable(route = Routes.HomePage.route) {
            onTitleChange("City")
            HomeScreen(
                onCategoryClick = { category ->
                    navController.navigate(
                        Routes.Category.createRoute(category.id)
                    )
                }
            )
        }

        // Category. В аргументах передаем id всех категорий
        composable(
            route = Routes.Category.route, // "category/{categoryId}"
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType }
            )
        ) { backStackEntry -> // backStackEntry - объект текущего экрана, который хранит аргументы, пришедшие из route.

            val categoryId = backStackEntry.arguments?.getInt("categoryId")

            // Берем первое значение, где совпадет categotyId
            val category = Category.values().firstOrNull { it.id == categoryId }

            category?.let {
                onTitleChange(stringResource(it.titleResId))

                RecommendationsListScreen(
                    category = it,
                    onRecommendationClick = { id ->
                        navController.navigate(
                            Routes.Recommendation.createRoute(id)
                        )
                    }
                )
            }
        }

        // Recommendation. В аргументах передаем id всех рекомендаций
        composable(
            route = Routes.Recommendation.route,
            arguments = listOf(
                navArgument("id") {type = NavType.IntType}
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("id")
            val recommendation = id?.let { CityRepository.getById(it) }

            // Если recommendation = null - экран не рисуется, иначе рисуется
            recommendation?.let {
                onTitleChange(stringResource(it.titleResId))

                RecommendationScreen(
                    recommendation = it
                )
            }
        }

        composable(route = Routes.About.route) {
            onTitleChange("О приложении")
            AboutScreen()
        }

        composable(route = Routes.Settings.route) {
            onTitleChange("Настройки")
            SettingsScreen()
        }

        composable(route = Routes.Favorites.route) {
            onTitleChange("Favorites")
            FavoritesScreen() // экран со списком избранного
        }

        composable(Routes.Explore.route) {
            onTitleChange("Категории")

            ExploreScreen(
                onCategoryClick = { category ->
                    navController.navigate(
                        Routes.Category.createRoute(category.id)
                    )
                }
            )
        }
    }
}
