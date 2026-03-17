package com.example.city.model

import com.example.city.R

data class Recommendation (
    val id: Int,
    val titleResId: Int,
    val descriptionResId: Int,
    val addressResId: Int,
    val imageResId: Int,
    var category: Category
)

enum class Category (val id: Int, val titleResId: Int) {
    COFFEE(1, R.string.category_coffee),
    FOOD(2, R.string.category_food),
    KIDS(3, R.string.category_kids),
    PARKS(4, R.string.category_parks),
    SHOP(5, R.string.category_shop)
}