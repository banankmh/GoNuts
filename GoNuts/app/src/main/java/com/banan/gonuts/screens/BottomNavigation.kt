package com.banan.gonuts.screens

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.banan.gonuts.R
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.primary

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        Screens.HomeScreen,
        Screens.FavouriteScreen,
        Screens.NotificationScreen,
        Screens.CartScreen,
        Screens.ProfileScreen
    )
    BottomNavigation(
        backgroundColor = onPrimary,
        contentColor = primary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = "") },
                selectedContentColor = primary,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

