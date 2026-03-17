package com.example.city.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.city.R
import com.example.city.ui.components.CityDrawer
import com.example.city.ui.components.CityTopBar
import com.example.city.ui.navigation.*
import com.example.city.ui.utils.rememberIsTablet
import com.example.city.ui.viewmodels.CityAppViewModel
import kotlinx.coroutines.launch

@Composable
fun CityApp(viewModel: CityAppViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val navController = rememberNavController()
    val isTablet = rememberIsTablet()
    val scope = rememberCoroutineScope()

    val defaultTitle = stringResource(R.string.app_name)
    var topBarTitle by remember { mutableStateOf(defaultTitle) }

    // DrawerState синхронизируем с ViewModel
    val drawerState = rememberDrawerState(viewModel.drawerStateValue.value)

    val bottomNavItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Explore,
        BottomNavItem.Favorites
    )

    val currentDestination by navController.currentBackStackEntryAsState()
    val currentAppDestination = currentDestination?.destination?.toAppDestination()

    // Helper: закрыть drawer только на телефоне и обновить состояние в ViewModel
    fun closeDrawerIfNeeded() {
        if (!isTablet) scope.launch {
            drawerState.close()
            viewModel.setDrawerState(DrawerValue.Closed)
        }
    }

    // Helper: проверка, выделен ли item
    fun isSelectedCheck(item: BottomNavItem) =
        currentAppDestination?.let {
            item == viewModel.selectedBottomItem.value
        } ?: false

    // Drawer контент общий
    val drawerContent: @Composable () -> Unit = {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            CityDrawer(
                onHomeClick = {
                    closeDrawerIfNeeded()
                    viewModel.setSelectedBottomItem(BottomNavItem.Home)
                    navController.navigate(Routes.HomePage.route) {
                        launchSingleTop = true
                        popUpTo(Routes.HomePage.route) { inclusive = true }
                    }
                },
                onCategoryClick = { category ->
                    closeDrawerIfNeeded()
                    viewModel.setSelectedBottomItem(BottomNavItem.Explore)
                    navController.navigate(Routes.Category.createRoute(category.id))
                },
                onAboutClick = {
                    closeDrawerIfNeeded()
                    navController.navigate(Routes.About.route)
                },
                onSettingsClick = {
                    closeDrawerIfNeeded()
                    navController.navigate(Routes.Settings.route)
                }
            )
        }
    }

    val scaffoldContent: @Composable () -> Unit = {
        Row(modifier = Modifier.fillMaxSize()) {
            // Основной Scaffold (контент)
            Scaffold(
                modifier = Modifier.weight(1f),
                topBar = {
                    CityTopBar(
                        title = topBarTitle,
                        isTopLevel = currentAppDestination?.isTopLevel == true,
                        showMenu = !isTablet,
                        onMenuClick = { scope.launch { drawerState.open() } },
                        onBackClick = { navController.popBackStack() }
                    )
                },
                bottomBar = {
                    // Bottom bar только для телефонов
                    if (!isTablet) {
                        NavigationBar {
                            bottomNavItems.forEach { item ->
                                NavigationBarItem(
                                    icon = { Icon(item.icon, contentDescription = stringResource(item.labelResId)) },
                                    label = { Text(stringResource(item.labelResId)) },
                                    selected = isSelectedCheck(item),
                                    onClick = {
                                        viewModel.setSelectedBottomItem(item)
                                        navController.navigate(item.route) {
                                            launchSingleTop = true
                                            popUpTo(navController.graph.startDestinationId) { inclusive = true }
                                        }
                                    }
                                )
                            }
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

            // NavigationRail для планшета справа
            if (isTablet) {
                NavigationRail {
                    bottomNavItems.forEach { item ->
                        NavigationRailItem(
                            icon = { Icon(item.icon, contentDescription = stringResource(item.labelResId)) },
                            label = { Text(stringResource(item.labelResId)) },
                            selected = isSelectedCheck(item),
                            onClick = {
                                viewModel.setSelectedBottomItem(item)
                                navController.navigate(item.route) {
                                    launchSingleTop = true
                                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }

    if (isTablet) {
        // Permanent drawer для планшета
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(modifier = Modifier.width(280.dp)) {
                    drawerContent()
                }
            }
        ) {
            scaffoldContent()
        }
    } else {
        // Modal drawer для телефонов
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    drawerContent()
                }
            }
        ) {
            scaffoldContent()
        }
    }
}