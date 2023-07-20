package com.banan.gonuts.screens.cart

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.gonuts.screens.Screens

fun NavGraphBuilder.cartRoute(navController: NavController){
    composable(route = Screens.CartScreen.route) {
        CartScreen(navController = navController)
    }
}
fun NavController.navigateToCart() {
    navigate( Screens.CartScreen.route)
}