package com.example.city.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.city.ui.components.CityDrawer
import com.example.city.ui.components.CityTopBar
import com.example.city.ui.navigation.*
import kotlinx.coroutines.launch
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

@Composable
fun CityApp() {
    val navController = rememberNavController()
    var topBarTitle by remember { mutableStateOf("City") }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Получаем текущую открытую вкладку
    val currentDestination by navController.currentBackStackEntryAsState()
    val currentAppDestination = currentDestination?.destination?.toAppDestination()

    val bottomNavItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Explore,
        BottomNavItem.Favorites
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            CityDrawer(
                onHomeClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate(Routes.HomePage.route) {
                        launchSingleTop = true
                        popUpTo(Routes.HomePage.route) { inclusive = true }
                    }
                },
                onCategoryClick = { category ->
                    scope.launch { drawerState.close() }
                    navController.navigate(Routes.Category.createRoute(category.id))
                },
                onAboutClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate(Routes.About.route)
                },
                onSettingsClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate(Routes.Settings.route)
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                CityTopBar(
                    title = topBarTitle,
                    isTopLevel = currentAppDestination?.isTopLevel == true,
                    onBackClick = { navController.popBackStack() },
                    onMenuClick = { scope.launch { drawerState.open() } },
                )
            },
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEach { item ->

                        // Подсветка иконки
                        val isSelected = when (item) {
                            BottomNavItem.Home -> currentAppDestination == AppDestination.Home ||
                                                  currentAppDestination == AppDestination.Settings ||
                                                  currentAppDestination == AppDestination.About

                            BottomNavItem.Favorites -> currentAppDestination == AppDestination.Favorites

                            BottomNavItem.Explore -> currentAppDestination == AppDestination.Explore ||
                                                     currentAppDestination == AppDestination.Category ||
                                                     currentAppDestination == AppDestination.Recommendation
                        }

                        NavigationBarItem(
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            label = { Text(item.label) },
                            selected = isSelected,
                            onClick = {
                                when (item) {
                                    BottomNavItem.Explore -> {
                                        navController.navigate(Routes.Explore.route) {
                                            launchSingleTop = true
                                            popUpTo(Routes.Explore.route) { inclusive = true } // Всегда возвращаемся к списку категорий
//                                            restoreState = true
//                                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                                        }
                                    }
                                    else -> {
                                        navController.navigate(item.route) {
                                            launchSingleTop = true
                                            restoreState = true
                                            popUpTo(navController.graph.startDestinationId) { saveState = true }
//                                            popUpTo(Routes.HomePage.route) { inclusive = true }
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            CityNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                onTitleChange = { title -> topBarTitle = title }
            )
        }
    }
}