package com.example.city.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.city.model.Recommendation

@Composable
fun RecommendationScreen(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(recommendation.imageResId),
            contentDescription = stringResource(recommendation.titleResId),
        )

        Text(
            text = stringResource(recommendation.titleResId)
        )

        Text(
            text = stringResource(recommendation.descriptionResId)
        )
    }
}
