package com.example.city.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.city.R
import com.example.city.model.Category

@Composable
fun CityDrawer(
    onHomeClick: () -> Unit,
    onCategoryClick: (Category) -> Unit,
    onAboutClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Заголовок
        Text(
            text = stringResource(R.string.app_name),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onHomeClick() }
                .padding(vertical = 8.dp)
        )

        Spacer(Modifier.height(24.dp))

        // Категории
        Text(
            text = stringResource(R.string.categories),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(8.dp))

        // Список категорий
        Category.values().forEach { category ->
            Text(
                text = stringResource(category.titleResId),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onCategoryClick(category) }
                    .padding(vertical = 12.dp)
            )
        }

        Spacer(Modifier.height(16.dp))
        Divider()
        Spacer(Modifier.height(16.dp))

        // О приложении
        Text(
            text = stringResource(R.string.about),
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onAboutClick)
                .padding(vertical = 12.dp)
        )

        // Настройки
        Text(
            text = stringResource(R.string.settings),
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onSettingsClick)
                .padding(vertical = 12.dp)
        )
    }
}