package com.example.city.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.city.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityTopBar(
    title: String,
    canNavigateBack: Boolean,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = { Text(title) },

        navigationIcon = {
            if (canNavigateBack) {
                TextButton(onClick = onBackClick) {
                    Text(stringResource(R.string.back))
                }
            }
        }
    )
}