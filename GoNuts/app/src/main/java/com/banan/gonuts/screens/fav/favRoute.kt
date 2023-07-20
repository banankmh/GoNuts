package com.banan.gonuts.screens.fav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.gonuts.screens.Screens

fun NavGraphBuilder.faveRoute(navController: NavController){
    composable(route = Screens.FavouriteScreen.route) {
        FavoriteScreen(navController = navController)
    }
}
fun NavController.navigateToFavourite() {
    navigate( Screens.FavouriteScreen.route)
}