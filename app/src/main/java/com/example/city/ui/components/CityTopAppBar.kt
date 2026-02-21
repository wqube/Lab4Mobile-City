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
    navController: NavController,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = { Text(title) },

        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                TextButton(onClick = { navController.popBackStack() }) {
                    Text(stringResource(R.string.back))
                }
            }
        }
    )
}

//    val backStackEntryState = navController.currentBackStackEntryAsState()
//    val backStackEntry = backStackEntryState.value
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = backStackEntry?.destination?.route
//    val arguments = backStackEntry?.arguments

//    TopAppBar(
//        title = {
//            Text(
//                text = when {
//                    currentRoute?.startsWith("category") == true ->
//                    {
//                        val categoryId = arguments?.getInt("categoryId")
//                        val category = Category.values().firstOrNull {it.id == categoryId}
//
//                        category?.let { stringResource(it.titleResId) } ?: stringResource(R.string.app_name)
//                    }
//
//                    currentRoute?.startsWith("recommendation") == true ->
//                    {
//                        val id = arguments?.getInt("id")
//                        val recommendation = id?.let { CityRepository.getById(it) }
//
//                        recommendation?.let { stringResource(it.titleResId) } ?: stringResource(R.string.app_name)
//                    }
//                    else -> stringResource(R.string.app_name)
//                }
//            )
//        },
//
//        navigationIcon = {
//            if (navController.previousBackStackEntry != null) {
//                TextButton(onClick = { navController.popBackStack() }) {
//                    Text(stringResource(R.string.back))
//                }
//            }
//        }
//    )
//}
