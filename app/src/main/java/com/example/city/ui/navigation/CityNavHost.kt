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
        composable(
            route = Routes.HomePage.route
        ) {
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
                    },
                    modifier = modifier
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
                    recommendation = it,
                    modifier = modifier
                )
            }
        }
    }
}