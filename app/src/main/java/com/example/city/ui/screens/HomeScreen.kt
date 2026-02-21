package com.example.city.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.city.model.Category
import com.example.city.ui.components.CategoryButton

@Composable
fun HomeScreen(
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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