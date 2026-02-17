package com.example.city.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.city.data.CityRepository
import com.example.city.model.Category
import com.example.city.model.Recommendation
import com.example.city.ui.navigation.Routes

@Composable
fun RecommendationListScreen(
    category: Category,
//    recommendations: List<Recommendation>,
    onRecommendationClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val recommendations = CityRepository.getByCategory(category = category)

    LazyColumn(modifier = modifier) {
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
