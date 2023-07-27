package com.banan.roomsession.screens.create_room

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.banan.roomsession.navigation.Screens

fun NavGraphBuilder.createRoomRoute(navController: NavController){
    composable(route = Screens.CreateRoomScreen.route) {
        CreateRoomScreen(navController = navController)
    }
}
fun NavController.navigateToCreateRoom() {
    navigate(Screens.CreateRoomScreen.route)
}