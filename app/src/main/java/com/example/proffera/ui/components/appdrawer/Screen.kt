package com.example.proffera.ui.components.appdrawer

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.proffera.NavRoutes
import com.example.proffera.ui.screen.home.HomeScreen
import com.example.proffera.ui.screen.profile.ProfileScreen

fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(startDestination = Screen.HomeScreen.name, route = NavRoutes.MainRoute.name) {
        composable(Screen.HomeScreen.name) {
            HomeScreen(drawerState)
        }
        composable(Screen.ProfileScreen.name) {
            ProfileScreen(drawerState)
        }
    }
}

enum class Screen {
    HomeScreen,
    DetailScreen,
    ProfileScreen,
    HistoryScreen,
    BookmarksScreen,
    LoginScreen,
    RegisterScreen,
    ProcurementScreen,
    ApplyScreen
}