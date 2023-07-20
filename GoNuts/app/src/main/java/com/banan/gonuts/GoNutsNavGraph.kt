package com.banan.gonuts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.banan.gonuts.screens.Screens
import com.banan.gonuts.screens.cart.cartRoute
import com.banan.gonuts.screens.details.detailsRoute
import com.banan.gonuts.screens.fav.faveRoute
import com.banan.gonuts.screens.home.homeRoute
import com.banan.gonuts.screens.onBoarding.onBoardingRoute
import com.banan.gonuts.screens.profile.notificationRoute
import com.banan.gonuts.screens.profile.profileRoute


@Composable
fun GoNutsNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.OnBoardingScreen.route) {
        onBoardingRoute(navController)
        homeRoute(navController)
        detailsRoute(navController)
        cartRoute(navController)
        faveRoute(navController)
        notificationRoute(navController)
        profileRoute(navController)
    }
}
