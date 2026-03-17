package com.example.city.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.city.data.CityRepository
import com.example.city.model.Category

@Composable
fun RecommendationsListScreen(
    category: Category,
    onRecommendationClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val recommendations = CityRepository.getByCategory(category = category)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn() {
            items(recommendations) { recommendation ->
                Text(
                    text = stringResource(recommendation.titleResId),
                    modifier = Modifier
                        .clickable { onRecommendationClick(recommendation.id) }
                        .padding(all = 16.dp)
                )
            }
        }
    }

}
