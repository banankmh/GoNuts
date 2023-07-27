package com.banan.roomsession.navigation

sealed class Screens(val route:String){
    object CreateVisitorScreen: Screens(route="CreateUserScreen")
    object CreateRoomScreen: Screens(route="CreateRoomScreen")
    object RoomScreen: Screens(route="RoomScreen")
}
