package com.example.city.ui.navigation

import com.example.city.model.Category

sealed class Routes(val route: String) {
    object HomePage: Routes("home")

    object Category: Routes("category/{categoryId}") {
        fun createRoute(categoryId: Int) = "category/$categoryId"
    }

    object Recommendation: Routes("recommendation/{id}") {
        fun createRoute(id: Int) = "recommendation/$id"
    }

    object About : Routes("about")

    object Settings : Routes("settings")
}