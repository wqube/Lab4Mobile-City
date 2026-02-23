package com.example.city.ui.viewmodels

import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.SavedStateHandle
import com.example.city.ui.navigation.BottomNavItem

class CityAppViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Состояние drawer
    var drawerStateValue = mutableStateOf(DrawerValue.Closed)
        private set

    // Выбранная вкладка BottomNavigation
    var selectedBottomItem: MutableState<BottomNavItem> = mutableStateOf(BottomNavItem.Home)
        private set

    fun setDrawerState(value: DrawerValue) {
        drawerStateValue.value = value
    }

    fun setSelectedBottomItem(item: BottomNavItem) {
        selectedBottomItem.value = item
    }
}