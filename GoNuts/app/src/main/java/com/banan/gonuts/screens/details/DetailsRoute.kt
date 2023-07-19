package com.banan.gonuts.screens.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.gonuts.screens.Screens

fun NavGraphBuilder.detailsRoute(navController: NavController){
    composable(route = Screens.DetailsScreen.route) {
        DetailsScreen(navController = navController)
    }
}
fun NavController.navigateToDetails() {
    navigate(Screens.DetailsScreen.route)
}