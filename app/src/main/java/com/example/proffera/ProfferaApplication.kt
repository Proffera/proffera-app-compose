package com.example.proffera

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.proffera.ui.components.appdrawer.AppDrawerContent
import com.example.proffera.ui.components.appdrawer.AppDrawerItemInfo
import com.example.proffera.ui.components.navigation.MainScreen
import com.example.proffera.ui.components.navigation.authGraph
import com.example.proffera.ui.components.navigation.mainGraph
import com.example.proffera.ui.components.navigation.splashGraph
import com.example.proffera.utils.UtilViewModel


@Composable
fun ProfferaApplication(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    viewModel: UtilViewModel = hiltViewModel(),
) {

    val isLoggedIn by viewModel.isLoggedIn.observeAsState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawerContent(
                drawerState = drawerState,
                menuItems = DrawerParams.drawerButtons,
                defaultPick = MainScreen.HomeScreen
            ) { onUserPickedOption ->
                when (onUserPickedOption) {
                    MainScreen.HomeScreen -> {
                        navController.navigate(onUserPickedOption.name) {
                            popUpTo(NavRoutes.MainRoute.name)
//                            {
//                                saveState = true
//                            }
//                            restoreState = true
//                            launchSingleTop = true
                        }
                    }
                    MainScreen.ProfileScreen -> {
                        navController.navigate(onUserPickedOption.name) {
                            popUpTo(NavRoutes.MainRoute.name)
//                            {
//                                saveState = true
//                            }
//                            restoreState = true
//                            launchSingleTop = true
                        }
                    }
                    MainScreen.Logout -> {
                        viewModel.logout()
                        navController.navigate(NavRoutes.AuthRoute.name) {
                            popUpTo(NavRoutes.AuthRoute.name) {
                                inclusive = true
                            }
                        }
                    }
                    else -> {}
                }
            }
        }
    ) {
        NavHost(
            navController,
            startDestination = NavRoutes.SplashRoute.name,
        ) {
            splashGraph(navController)
            authGraph(navController)
            mainGraph(drawerState)
        }
    }
}


enum class NavRoutes {
    SplashRoute,
    AuthRoute,
    MainRoute,
}

object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            MainScreen.HomeScreen,
            R.string.drawer_home,
            R.drawable.ic_info,
            R.string.drawer_home_description
        ),
        AppDrawerItemInfo(
            MainScreen.ProfileScreen,
            R.string.drawer_bookmarks,
            R.drawable.ic_info,
            R.string.drawer_bookmarks_description
        ),
        AppDrawerItemInfo(
            MainScreen.ProfileScreen,
            R.string.drawer_history,
            R.drawable.ic_info,
            R.string.drawer_history_description
        ),
        AppDrawerItemInfo(
            MainScreen.Logout,
            R.string.drawer_logout,
            R.drawable.ic_info,
            R.string.drawer_logout_description
        ),
    )
}