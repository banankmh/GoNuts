package com.banan.gonuts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.banan.gonuts.screens.Screens
import com.banan.gonuts.screens.details.detailsRoute
import com.banan.gonuts.screens.home.homeRoute
import com.banan.gonuts.screens.onBoarding.onBoardingRoute


@Composable
fun GoNutsNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.OnBoardingScreen.route) {
        onBoardingRoute(navController)
        homeRoute(navController)
        detailsRoute(navController)
    }
}
