package com.example.proffera.ui.components.navigation

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.proffera.NavRoutes
import com.example.proffera.ui.screen.home.HomeScreen
import com.example.proffera.ui.screen.profile.ProfileScreen

fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(startDestination = MainScreen.HomeScreen.name, route = NavRoutes.MainRoute.name) {
        composable(MainScreen.HomeScreen.name) {
            HomeScreen(drawerState)
        }
        composable(MainScreen.ProfileScreen.name) {
            ProfileScreen(drawerState)
        }
        composable(MainScreen.Logout.name) {

        }
    }
}

enum class MainScreen {
    HomeScreen,
    DetailScreen,
    ProfileScreen,
    HistoryScreen,
    BookmarksScreen,
    RegisterScreen,
    ProcurementScreen,
    ApplyScreen,
    Logout,
}