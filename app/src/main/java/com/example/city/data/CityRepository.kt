package com.example.city.data

import com.example.city.R
import com.example.city.model.Category
import com.example.city.model.Recommendation

object CityRepository {
    private val recommendations = listOf(
        Recommendation(
            id = 1,
            titleResId = R.string.coffee_1_title,
            descriptionResId = R.string.coffee_1_desc,
            imageResId = R.drawable.tasty_coffee_logo,
            category = Category.COFFEE
        ),
        Recommendation(
            id = 2,
            titleResId = R.string.coffee_2_title,
            descriptionResId = R.string.coffee_2_desc,
            imageResId = R.drawable.coffee_moose_logo,
            category = Category.COFFEE
    )
    )

    fun getByCategory(category: Category): List<Recommendation> {
        return recommendations.filter { it.category == category }
    }

    fun getById(id: Int): Recommendation? {
        return recommendations.find { it.id == id }
    }
}