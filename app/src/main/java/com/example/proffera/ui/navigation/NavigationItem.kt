package com.example.proffera.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.proffera.ui.components.appdrawer.Screen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)
