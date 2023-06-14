package com.example.proffera

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.proffera.ui.components.appdrawer.AppDrawerContent
import com.example.proffera.ui.components.appdrawer.AppDrawerItemInfo
import com.example.proffera.ui.components.navigation.MainScreen
import com.example.proffera.ui.components.navigation.authGraph
import com.example.proffera.ui.components.navigation.mainGraph
import com.example.proffera.utils.UtilViewModel


@Composable
fun ProfferaApplication(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    viewModel: UtilViewModel = hiltViewModel(),
) {

    val isLoggedIn by viewModel.isLoggedIn.observeAsState()

    LaunchedEffect(key1 = isLoggedIn) {
        if (isLoggedIn == false) {
            // User is not logged in, navigate to the LoginRoute
            navController.navigate(NavRoutes.LoginRoute.name) {
                popUpTo(NavRoutes.LoginRoute.name)
                launchSingleTop = true
            }
        }
    }

    Surface {
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
                            }
                        }
                        MainScreen.ProfileScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }
                        MainScreen.Logout -> {
                            viewModel.logout()
                            navController.navigate(NavRoutes.LoginRoute.name) {
                                popUpTo(NavRoutes.LoginRoute.name){
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
                startDestination = NavRoutes.LoginRoute.name
            ) {
                authGraph(navController)
                mainGraph(drawerState)
            }
        }
    }
}

enum class NavRoutes {
    LoginRoute,
    MainRoute,
    RegisterRoute,
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