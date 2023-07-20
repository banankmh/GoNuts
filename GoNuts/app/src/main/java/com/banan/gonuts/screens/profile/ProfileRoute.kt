package com.banan.gonuts.screens.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.gonuts.screens.Screens

fun NavGraphBuilder.profileRoute(navController: NavController){
    composable(route = Screens.ProfileScreen.route) {
        ProfileScreen(navController = navController)
    }
}
fun NavController.navigateToProfile() {
    navigate( Screens.ProfileScreen.route)
}