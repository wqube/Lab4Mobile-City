package com.example.city.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.city.ui.components.CityDrawer
import com.example.city.ui.navigation.CityNavHost
import com.example.city.ui.components.CityTopBar
import com.example.city.ui.navigation.Routes
import com.example.city.ui.navigation.toAppDestination
import kotlinx.coroutines.launch

@Composable
fun CityApp() {
    val navController = rememberNavController()
    var topBarTitle by remember { mutableStateOf("City") }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val currentDestination =
        navController.currentBackStackEntryAsState()
            .value?.destination
            .toAppDestination()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            CityDrawer(
                onHomeClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate(Routes.HomePage.route) {
                        popUpTo(Routes.HomePage.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onCategoryClick = {
                    category ->
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
                    isTopLevel = currentDestination?.isTopLevel == true,
                    onBackClick = { navController.popBackStack() },
                    onMenuClick = { scope.launch { drawerState.open() } },
                )
            }
        ) { innerPadding ->
            CityNavHost(
                navController = navController,
                modifier = Modifier
                    .padding(innerPadding),
                onTitleChange = { title ->
                    topBarTitle = title
                }
            )
        }
    }
}
