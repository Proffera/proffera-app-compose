package com.example.proffera

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.proffera.ui.components.appdrawer.AppDrawerContent
import com.example.proffera.ui.components.appdrawer.AppDrawerItemInfo
import com.example.proffera.ui.components.appdrawer.Screen
import com.example.proffera.ui.components.appdrawer.mainGraph

@Composable
fun ProfferaApplication(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    Surface {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                AppDrawerContent(
                    drawerState = drawerState,
                    menuItems = DrawerParams.drawerButtons,
                    defaultPick = Screen.HomeScreen
                ) { onUserPickedOption ->
                    when (onUserPickedOption) {
                        Screen.HomeScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }
                        Screen.ProfileScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }
                        else -> {}
                    }
                }
            }
        ) {
            NavHost(
                navController,
                startDestination = NavRoutes.MainRoute.name
            ) {
                mainGraph(drawerState)
            }
        }
    }
}

enum class NavRoutes {
    MainRoute,
}

object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            Screen.HomeScreen,
            R.string.drawer_home,
            R.drawable.ic_info,
            R.string.drawer_home_description
        ),
        AppDrawerItemInfo(
            Screen.ProfileScreen,
            R.string.drawer_bookmarks,
            R.drawable.ic_info,
            R.string.drawer_bookmarks_description
        ),
        AppDrawerItemInfo(
            Screen.ProfileScreen,
            R.string.drawer_history,
            R.drawable.ic_info,
            R.string.drawer_history_description
        ),
        AppDrawerItemInfo(
            Screen.ProfileScreen,
            R.string.drawer_logout,
            R.drawable.ic_info,
            R.string.drawer_logout_description
        ),
    )
}