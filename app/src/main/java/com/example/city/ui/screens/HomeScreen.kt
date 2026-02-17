package com.example.city.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.city.model.Category
import com.example.city.ui.components.CategoryButton

@Composable
fun HomeScreen(
    onCategoryClick: (Category) -> Unit
) {
    Column {
        CategoryButton(
            title = stringResource(Category.COFFEE.titleResId),
            onClick = { onCategoryClick(Category.COFFEE) }
        )

        CategoryButton(
            title = stringResource(Category.FOOD.titleResId),
            onClick = { onCategoryClick(Category.FOOD) }
        )

        CategoryButton(
            title = stringResource(Category.KIDS.titleResId),
            onClick = { onCategoryClick(Category.KIDS) }
        )

        CategoryButton(
            title = stringResource(Category.PARKS.titleResId),
            onClick = { onCategoryClick(Category.PARKS) }
        )

        CategoryButton(
            title = stringResource(Category.SHOP.titleResId),
            onClick = { onCategoryClick(Category.SHOP) }
        )
    }
}