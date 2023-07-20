package com.banan.gonuts.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.gonuts.screens.Screens

fun NavGraphBuilder.homeRoute(navController: NavController){
    composable(route = Screens.HomeScreen.route) {
       HomeScreen(navController = navController)
    }
}

fun NavController.navigateToHome() {
    navigate(Screens.HomeScreen.route)
}