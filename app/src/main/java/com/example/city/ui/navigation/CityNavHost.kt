package com.example.city.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.city.ui.screens.HomeScreen
import androidx.navigation.navArgument
import com.example.city.data.CityRepository
import com.example.city.model.Category
import com.example.city.ui.screens.RecommendationListScreen
import com.example.city.ui.screens.RecommendationScreen

@Composable
fun CityNavHost() {
    // Этот контроллер хранит текущий экран, back stack, аргументы. Не пересоздается при рекомпозиции
    // navController создается благодаря нему
    val navController = rememberNavController()

    // Контейнер экранов
    NavHost(
        navController = navController,
        startDestination = Routes.HomePage.route
    ) {
        // Home
        composable(
            route = Routes.HomePage.route
        ) {
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
            route = Routes.Category.route,
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType }
            )
            // backStackEntry - объект текущего экрана, который хранит аргументы, пришедшие из route.
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId")!!

            // Берем первое значение, где совпадет categotyId
            val category = Category.values().first { it.id == categoryId }

            RecommendationListScreen(
                category = category,
                onRecommendationClick = { id ->
                    navController.navigate(
                        Routes.Recommendation.createRoute(id)
                    )
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // Recommendation. В аргументах передаем id всех рекомендаций
        composable(
            route = Routes.Recommendation.route,
            arguments = listOf(
                navArgument("id") {type = NavType.IntType}
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")!!

            val recommendation = CityRepository.getById(id)

            // Если recommendation = null - экран не рисуется, иначе рисуется
            recommendation?.let { RecommendationScreen(
                recommendation = it,
                onBackClick = {
                    navController.popBackStack()
                }
            ) }
            }
    }
}