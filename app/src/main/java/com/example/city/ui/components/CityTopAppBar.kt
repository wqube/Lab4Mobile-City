package com.example.city.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.city.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityTopBar(
    title: String,
    isTopLevel: Boolean,
    showMenu: Boolean,
    onMenuClick: () -> Unit,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            when {
                // Не top-level → всегда back
                !isTopLevel -> {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            Icons.AutoMirrored.Filled.ArrowBack
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }

                // Top-level + можно показывать меню (phone)
                showMenu -> {
                    IconButton(onClick = onMenuClick) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = stringResource(R.string.cd_open_menu)
                        )
                    }
                }

                // Top-level + tablet → иконки нет
                else -> {
                    // intentionally empty
                }
            }
        }
    )
}