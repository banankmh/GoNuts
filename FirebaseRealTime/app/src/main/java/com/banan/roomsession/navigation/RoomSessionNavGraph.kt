package com.banan.roomsession.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.banan.roomsession.screens.create_room.createRoomRoute
import com.banan.roomsession.screens.create_visitor.createVisitorRoute
import com.banan.roomsession.screens.room.roomRoute

@Composable
fun RoomSessionNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.CreateVisitorScreen.route) {
        createRoomRoute(navController = navController)
        createVisitorRoute(navController = navController)
        roomRoute(navController = navController)
    }
}