package com.banan.gonuts.screens.onBoarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.gonuts.screens.Screens

fun NavGraphBuilder.onBoardingRoute(navController: NavController){
    composable(route = Screens.OnBoardingScreen.route) {
        OnBoardingScreen(navController = navController)
    }
}
fun NavController.navigateToOnBoarding() {
    navigate(Screens.OnBoardingScreen.route)
}