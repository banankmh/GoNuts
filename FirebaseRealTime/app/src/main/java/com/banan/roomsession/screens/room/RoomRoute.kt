package com.banan.roomsession.screens.room

import RoomScreen
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.banan.roomsession.navigation.Screens

fun NavGraphBuilder.roomRoute(navController: NavController){
    composable(
        route = "${Screens.RoomScreen.route}/{${RoomArgs.ID}}",
        arguments = listOf(navArgument(RoomArgs.ID) { type = NavType.StringType }
        )
    ) {
        RoomScreen(navController = navController)
    }
}
fun NavController.navigateToRoom(id:String) {
    navigate("${Screens.RoomScreen.route}/$id")
    Log.e("navigateToRoom",id)
}

class RoomArgs(savedStateHandle: SavedStateHandle) {
    val id: String = checkNotNull(savedStateHandle[ID])
    companion object {
        const val ID = "id"
    }
}