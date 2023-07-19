package com.banan.gonuts.screens.onBoarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.gonuts.screens.Screens

fun NavGraphBuilder.onBoardingRoute(navController: NavController){
    composable(route = Screens.HomeScreen.route) {
        OnBoardingScreen(navController = navController)
    }
}
