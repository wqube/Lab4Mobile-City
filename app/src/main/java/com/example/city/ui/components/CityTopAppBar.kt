package com.example.city.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.city.R
import com.example.city.ui.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityTopBar(
    title: String,
    isTopLevel: Boolean,
    onMenuClick: () -> Unit,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (isTopLevel) {
                TextButton(onClick = onMenuClick) {
                    Text("≡")
                }
            } else {
                TextButton(onClick = onBackClick) {
                    Text("Назад")
                }
            }
        }
    )
}