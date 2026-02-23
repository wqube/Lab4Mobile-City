package com.example.city.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.city.R

@Composable
fun FavoritesScreen() {

    val favorites = listOf(
        R.string.coffee_1_title,
        R.string.food_1_title,
        R.string.parks_1_title,
        R.string.shop_1_title
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(favorites) { titleResId ->
            FavoriteItem(titleResId = titleResId)
        }
    }
}

@Composable
private fun FavoriteItem(
    titleResId: Int,
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(titleResId),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(R.string.favorites_added),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}