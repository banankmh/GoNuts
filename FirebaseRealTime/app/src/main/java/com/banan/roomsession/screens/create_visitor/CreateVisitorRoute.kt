package com.banan.roomsession.screens.create_visitor

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.roomsession.navigation.Screens

fun NavGraphBuilder.createVisitorRoute(navController: NavController){
    composable(route = Screens.CreateVisitorScreen.route) {
        CreateVisitorScreen(navController = navController)
    }
}
fun NavController.navigateToCreateVisitor() {
    navigate(Screens.CreateVisitorScreen.route)
}