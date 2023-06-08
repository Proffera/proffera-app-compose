package com.example.proffera.ui.navigation

sealed class Screen(val route: String)
{
    object Home : Screen("home")
    object Detail : Screen("detail")
    object Profile : Screen("profile")
    object History : Screen("history")
    object Bookmarks : Screen("bookmarks")
    object Login : Screen("login")
    object Register : Screen("register")
    object Procurement : Screen("procurement")
    object Apply : Screen("apply")
}
